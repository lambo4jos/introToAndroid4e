package com.introtoandroid.simplemultimedia; 

import java.io.FileOutputStream;
import java.util.List;
import java.util.ListIterator;

import com.androidintro.simplemultimedia.R;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class StillImageActivity extends Activity {
    private static final String DEBUG_TAG = "StillImageActivity";
    final private static String STILL_IMAGE_FILE = "capture.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.still);
        final CameraSurfaceView cameraView = new CameraSurfaceView(
                getApplicationContext());
        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        frame.addView(cameraView);
        Button capture = (Button) findViewById(R.id.capture);
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(DEBUG_TAG, "Requesting capture");
                cameraView.capture(new Camera.PictureCallback() {
                    public void onPictureTaken(byte[] data, Camera camera) {
                        Log.v("Still", "Image data received from camera");
                        FileOutputStream fos;
                        try {
                            // Fully qualified path name. In this case, we
                            // use the Files subdir
                            String pathForAppFiles = getFilesDir()
                                    .getAbsolutePath();
                            pathForAppFiles = pathForAppFiles + "/"
                                    + STILL_IMAGE_FILE;
                            Log.d("Still image filename:", pathForAppFiles);
                            fos = openFileOutput(STILL_IMAGE_FILE, 0);
                            fos.write(data);
                            fos.close();
                        } catch (Exception e) {
                            Log.e("Still", "Error writing file", e);
                        }
                    }
                });
            }
        });
        Button paper = (Button) findViewById(R.id.wallpaper);
        paper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cameraView.capture(new Camera.PictureCallback() {
                    public void onPictureTaken(byte[] data, Camera camera) {
                        Log.v("Still", "Image data received from camera");
                        Bitmap recordedImage = BitmapFactory.decodeByteArray(
                                data, 0, data.length);
                        try {
                            WallpaperManager wpManager = WallpaperManager
                                    .getInstance(StillImageActivity.this);
                            int height = wpManager.getDesiredMinimumHeight();
                            int width = wpManager.getDesiredMinimumWidth();
                            Toast.makeText(getApplicationContext(),
                                    "Wallpaper size = " + width + "x" + height,
                                    Toast.LENGTH_LONG).show();
                            Log.v("Still", "Wallpaper size=" + width + "x"
                                    + height);
                            Bitmap scaledImage = Bitmap.createScaledBitmap(
                                    recordedImage, width, height, false);
                            wpManager.setBitmap(scaledImage);
                        } catch (Exception e) {
                            Log.e("Still", "Setting wallpaper failed.", e);
                        }
                    }
                });
            }
        });
    }

    private class CameraSurfaceView extends SurfaceView implements
            SurfaceHolder.Callback {
        private Camera camera = null;
        private SurfaceHolder mHolder = null;
        private int cameraId = 0;

        public CameraSurfaceView(Context context) {
            super(context);
            // Install a SurfaceHolder.Callback so we get notified when the
            // underlying surface is created and destroyed
            mHolder = getHolder();
            mHolder.addCallback(this);

            // optional -- use the front facing camera
            CameraInfo info = new CameraInfo();
            for (int camIndex = 0; camIndex < Camera.getNumberOfCameras(); camIndex++) {
                Camera.getCameraInfo(camIndex, info);
                if (info.facing == CameraInfo.CAMERA_FACING_FRONT) {
                    cameraId = camIndex;
                    break;
                }
            }
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                int height) {
            try {
                Camera.Parameters params = camera.getParameters();
                // not all cameras supporting setting arbitrary sizes
                List<Camera.Size> sizes = params.getSupportedPreviewSizes();
                Camera.Size pickedSize = getBestFit(sizes, width, height);
                if (pickedSize != null) {
                    params.setPreviewSize(pickedSize.width, pickedSize.height);
                    Log.d(DEBUG_TAG, "Preview size: (" + pickedSize.width + ","
                            + pickedSize.height + ")");
                    // even after setting a supported size, the preview size may
                    // still end up just being the surface size (supported or
                    // not)
                    camera.setParameters(params);
                }
                // set the orientation to standard portrait.
                // Do this only if you know the specific orientation (0,90,180,
                // etc.)
                // Only works on API Level 8+
                if  (pickedSize != null) {
                    setCameraDisplayOrientation(pickedSize.width, pickedSize.height);
                } else {
                    Camera.Size previewSize = camera.getParameters().getPreviewSize();
                    setCameraDisplayOrientation(previewSize.width, previewSize.height);
                }
                camera.startPreview();
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "Failed to set preview size", e);
            }
        }

        private Size getBestFit(List<Size> sizes, int width, int height) {
            Size bestFit = null;
            ListIterator<Size> items = sizes.listIterator();
            while (items.hasNext()) {
                Size item = items.next();
                if (item.width <= width && item.height <= height) {
                    if (bestFit != null) {
                        // if our current best fit has a smaller area, then we
                        // want the new one (bigger area == better fit)
                        if (bestFit.width * bestFit.height < item.width
                                * item.height) {
                            bestFit = item;
                        }
                    } else {
                        bestFit = item;
                    }
                }
            }
            return bestFit;
        }

        private void setCameraDisplayOrientation(int width, int height) {
            CameraInfo info = new CameraInfo();
            Camera.getCameraInfo(cameraId, info);
            int rotation = getWindowManager().getDefaultDisplay().getRotation();
            int degrees = rotation * 90;

            int result;
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                result = (info.orientation + degrees) % 360;
                result = (360 - result) % 360;
            } else {
                result = (info.orientation - degrees + 360) % 360;
            }
            camera.setDisplayOrientation(result);

            if (result == 90 || result == 270) {
                mHolder.setFixedSize(height, width);
            } else {
                mHolder.setFixedSize(width, height);

            }
        }

        public void surfaceCreated(SurfaceHolder holder) {
            camera = Camera.open(cameraId);
            try {
                camera.setPreviewDisplay(mHolder);
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "Failed to set camera preview display", e);
            }
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            camera.stopPreview();
            camera.release();
            camera = null;
        }

        public boolean capture(Camera.PictureCallback jpegHandler) {
            if (camera != null) {
                camera.takePicture(null, null, jpegHandler);
                return true;
            } else {
                return false;
            }
        }
    }
}
