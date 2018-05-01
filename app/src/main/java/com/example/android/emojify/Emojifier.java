package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by bratner on 5/1/18.
 */

public class Emojifier {
    public static final String TAG = Emojifier.class.getSimpleName();
    public static int detectFaces(Context context, Bitmap bitmap) {
        int ret = 0;
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        SparseArray<Face> faces = detector.detect(frame);
        Log.d(TAG, "Detected "+faces.size()+" faces.");
        for(int i=0; i<faces.size(); i++) {
            Log.d(TAG, "Face "+i+": "+faces.get(i).toString());
        }
        ret = faces.size();
        detector.release();
        return ret;
    }
}
