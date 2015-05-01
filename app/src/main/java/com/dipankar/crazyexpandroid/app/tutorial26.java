//carvd motion
package com.dipankar.crazyexpandroid.app;
        import android.animation.ObjectAnimator;
        import android.app.Activity;
        import android.graphics.Point;
        import android.os.Bundle;
        import android.view.Display;
        import android.view.View;
        import android.widget.Button;
        import java.util.ArrayList;
        import java.util.Collection;
        import android.animation.TypeEvaluator;
public class tutorial26 extends Activity {
    Button mButton;
    PathEvaluator mEvaluator = new PathEvaluator();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial26);

        mButton = (Button) findViewById(R.id.button);

        // Build the path...
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int xend = size.x - 100;
        int yend = size.y - 100;
        //Here, we are constructing an AnimatorPath  and supplying it with operations that will become
        // points in the path, along with the operations to navigate the intervals up to those points.
        // The first operation defines where the path starts, (0, 0). Then we move in a straight line
        // to (0, 300). Finally, we move along a curve (a cubic Bézier curve, to be precise) to
        // the point (400, 500), using control points (100, 0) and (300, 900) along the way.


        AnimatorPath path = new AnimatorPath();
        /*
        path.moveTo(0, 0);
        path.lineTo(0, yend/2);
        path.curveTo(0, 4*yend/5, yend, xend/5, xend/2, yend);
        path.lineTo(xend, yend);
        */
        path.moveTo(0, 0);
        path.curveTo(0,300, yend, 300 , xend, yend);

        // Set up the animation
        final ObjectAnimator anim = ObjectAnimator.ofObject(this, "buttonLoc",
                new PathEvaluator(), path.getPoints().toArray());
        anim.setDuration(5000);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.start();
            }
        });

    }

    /**
     * We need this setter to translate between the information the animator
     * produces (a new "PathPoint" describing the current animated location)
     * and the information that the button requires (an xy location). The
     * setter will be called by the ObjectAnimator given the 'buttonLoc'
     * property string.
     */
    public void setButtonLoc(PathPoint newLoc) {
        mButton.setTranslationX(newLoc.mX);
        mButton.setTranslationY(newLoc.mY);
    }

}

//*********** Neat Aree All mAthemetric for path calculations....
class PathPoint {
    public static final int MOVE = 0;
    public static final int LINE = 1;
    public static final int CURVE = 2;
    float mX, mY;
    float mControl0X, mControl0Y;
    float mControl1X, mControl1Y;
    int mOperation;
    private PathPoint(int operation, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
    }
    private PathPoint(float c0X, float c0Y, float c1X, float c1Y, float x, float y) {
        mControl0X = c0X;
        mControl0Y = c0Y;
        mControl1X = c1X;
        mControl1Y = c1Y;
        mX = x;
        mY = y;
        mOperation = CURVE;
    }
    public static PathPoint lineTo(float x, float y) {
        return new PathPoint(LINE, x, y);
    }
    public static PathPoint curveTo(float c0X, float c0Y, float c1X, float c1Y, float x, float y) {
        return new PathPoint(c0X,  c0Y, c1X, c1Y, x, y);
    }
    public static PathPoint moveTo(float x, float y) {
        return new PathPoint(MOVE, x, y);
    }
}


// A simple Path object that holds information about the points along a path.
class AnimatorPath {

    // The points in the path
    ArrayList<PathPoint> mPoints = new ArrayList<PathPoint>();
    public void moveTo(float x, float y) {
        mPoints.add(PathPoint.moveTo(x, y));
    }
    public void lineTo(float x, float y) {
        mPoints.add(PathPoint.lineTo(x, y));
    }
// Create a cubic BŽzier curve from the current path point to the new one
    public void curveTo(float c0X, float c0Y, float c1X, float c1Y, float x, float y) {
        mPoints.add(PathPoint.curveTo(c0X, c0Y, c1X, c1Y, x, y));
    }

//Returns a Collection of PathPoint objects that describe all points in the path.
    public Collection<PathPoint> getPoints() {
        return mPoints;
    }
}

// This evaluator interpolates between two PathPoint values given the value t,
 class PathEvaluator implements TypeEvaluator<PathPoint> {
    @Override
    public PathPoint evaluate(float t, PathPoint startValue, PathPoint endValue) {
        float x, y;
        if (endValue.mOperation == PathPoint.CURVE) {
            float oneMinusT = 1 - t;
            x = oneMinusT * oneMinusT * oneMinusT * startValue.mX +
                    3 * oneMinusT * oneMinusT * t * endValue.mControl0X +
                    3 * oneMinusT * t * t * endValue.mControl1X +
                    t * t * t * endValue.mX;
            y = oneMinusT * oneMinusT * oneMinusT * startValue.mY +
                    3 * oneMinusT * oneMinusT * t * endValue.mControl0Y +
                    3 * oneMinusT * t * t * endValue.mControl1Y +
                    t * t * t * endValue.mY;
        } else if (endValue.mOperation == PathPoint.LINE) {
            x = startValue.mX + t * (endValue.mX - startValue.mX);
            y = startValue.mY + t * (endValue.mY - startValue.mY);
        } else {
            x = endValue.mX;
            y = endValue.mY;
        }
        return PathPoint.moveTo(x, y);
    }
}
