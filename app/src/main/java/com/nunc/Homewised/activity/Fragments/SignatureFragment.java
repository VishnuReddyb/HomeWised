package com.nunc.Homewised.activity.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nunc.Homewised.R;

import java.io.ByteArrayOutputStream;


/**
 * Created by nunc.
 */
public class SignatureFragment extends Fragment {
    private Button clear, save;
    private GestureOverlayView signaturePad;
    private GestureLibrary mLibrary;
    View rootView;
    private TextView text_signaturename;
    private LinearLayout mysignature;
    private Activity activity;
    signature mSignature;
    public SignatureFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_signature, container, false);
        this.activity = getActivity();
        save = (Button)rootView. findViewById(R.id.save);
        save.setEnabled(false);
        clear = (Button)rootView. findViewById(R.id.clear);
        text_signaturename = (TextView)rootView. findViewById(R.id.text_signaturename);
        mysignature = (LinearLayout)rootView. findViewById(R.id.mysignature);

        mSignature = new signature(activity, null);
        mysignature.addView(mSignature);

        save.setOnClickListener(onButtonClick);
        clear.setOnClickListener(onButtonClick);
//        signaturePad = (GestureOverlayView) rootView.findViewById(R.id.signaturePad);
        return rootView;
    }

    Button.OnClickListener onButtonClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (v == clear) {
                mSignature.clear();
            } else if (v == save) {
                mSignature.save();
            }
        }
    };

    private class signature extends View {
        static final float STROKE_WIDTH = 10f;
        static final float HALF_STROKE_WIDTH = STROKE_WIDTH / 2;
        Paint paint = new Paint();
        Path path = new Path();

        float lastTouchX;
        float lastTouchY;
        final RectF dirtyRect = new RectF();

        public signature(Context context, AttributeSet attrs) {
            super(context, attrs);
            paint.setAntiAlias(true);
            paint.setColor(getResources().getColor(R.color.blue));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeWidth(STROKE_WIDTH);
        }

        public void clear() {
            path.reset();
            invalidate();
            save.setEnabled(false);
        }

        public void save() {
            Bitmap returnedBitmap = Bitmap.createBitmap(mysignature.getWidth(),
                    mysignature.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(returnedBitmap);
            Drawable bgDrawable = mysignature.getBackground();
            if (bgDrawable != null)
                bgDrawable.draw(canvas);
            else
                canvas.drawColor(Color.WHITE);
            mysignature.draw(canvas);

            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            returnedBitmap.compress(Bitmap.CompressFormat.PNG, 100, bs);
            Intent intent = new Intent();
            intent.putExtra("byteArray", bs.toByteArray());
            activity.setResult(1, intent);

            Toast.makeText(activity,
                    "Image saved successfully at " , Toast.LENGTH_SHORT).show();
           // activity.finish();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // TODO Auto-generated method stub
            canvas.drawPath(path, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float eventX = event.getX();
            float eventY = event.getY();
            save.setEnabled(true);

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(eventX, eventY);
                    lastTouchX = eventX;
                    lastTouchY = eventY;
                    return true;

                case MotionEvent.ACTION_MOVE:

                case MotionEvent.ACTION_UP:

                    resetDirtyRect(eventX, eventY);
                    int historySize = event.getHistorySize();
                    for (int i = 0; i < historySize; i++) {
                        float historicalX = event.getHistoricalX(i);
                        float historicalY = event.getHistoricalY(i);
                        path.lineTo(historicalX, historicalY);
                    }
                    path.lineTo(eventX, eventY);
                    break;
            }

            invalidate((int) (dirtyRect.left - HALF_STROKE_WIDTH),
                    (int) (dirtyRect.top - HALF_STROKE_WIDTH),
                    (int) (dirtyRect.right + HALF_STROKE_WIDTH),
                    (int) (dirtyRect.bottom + HALF_STROKE_WIDTH));

            lastTouchX = eventX;
            lastTouchY = eventY;

            return true;
        }

        private void resetDirtyRect(float eventX, float eventY) {
            dirtyRect.left = Math.min(lastTouchX, eventX);
            dirtyRect.right = Math.max(lastTouchX, eventX);
            dirtyRect.top = Math.min(lastTouchY, eventY);
            dirtyRect.bottom = Math.max(lastTouchY, eventY);
        }
    }
}
       /* btn_clearsignature=(Button)rootView.findViewById(R.id.btn_clearsignature);
        mLibrary = GestureLibraries.fromRawResource(activity, R.raw.spells);
        if (!mLibrary.load()) {
            activity.finish();
        }
        GestureOverlayView gestures = (GestureOverlayView)rootView.findViewById(R.id.signaturePad);
        gestures.addOnGesturePerformedListener(this);
        btn_clearsignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

Button.OnClickListener onButtonClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (v == clear) {
                mSignature.clear();
            } else if (v == save) {
                mSignature.save();
            }
        }
    };
        // Inflate the layout for this fragment
        return rootView;
    }
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> predictions = mLibrary.recognize(gesture);

        // We want at least one prediction
        if (predictions.size() > 0) {
            Prediction prediction = predictions.get(0);
            // We want at least some confidence in the result
            if (prediction.score > 1.0) {
                // Show the spell
                Toast.makeText(activity, prediction.name, Toast.LENGTH_SHORT).show();
            }
        }*/



