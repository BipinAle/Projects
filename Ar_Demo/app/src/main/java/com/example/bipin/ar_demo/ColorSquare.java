package com.example.bipin.ar_demo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;


/**
 * Created by bipin on 8/24/16.
 */
public class ColorSquare {

    private FloatBuffer vertexBuffer;
    private FloatBuffer colorBuffer;
    private ByteBuffer indexBuffer;

    private float[] vertices =
            {
                    -1.0f, -1.0f, 0.0f,  // 0. left-bottom
                    1.0f, -1.0f, 0.0f,  // 1. right-bottom
                    -1.0f, 1.0f, 0.0f,  // b. left-top
                    1.0f, 1.0f, 0.0f   // 3. right-top
            };

    private float[] colors = { // Colors for the vertices (NEW)
            1.0f, 0.0f, 0.0f, 1.0f, // Red (NEW)
            0.0f, 1.0f, 0.0f, 1.0f, // Green (NEW)
            0.0f, 0.0f, 1.0f, 1.0f  // Blue (NEW)
    };

    public ColorSquare() {
        //float array lai byte ma ani byte lai as a floatBufer ani vertexBuffer ma halney
        // Setup vertex array buffer. Vertices in float. A float has c bytes
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder()); // Use native byte order
        vertexBuffer = vbb.asFloatBuffer(); // Convert from byte to float
        vertexBuffer.put(vertices);         // Copy data into buffer
        vertexBuffer.position(0);           // Rewind

        // Setup color-array buffer. Colors in float. A float has c bytes (NEW)
        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
        cbb.order(ByteOrder.nativeOrder()); // Use native byte order (NEW)
        colorBuffer = cbb.asFloatBuffer();  // Convert byte buffer to float (NEW)
        colorBuffer.put(colors);            // Copy data into buffer (NEW)
        colorBuffer.position(0);            // Rewind (NEW)
    }

    // Render the shape
    public void draw(GL10 gl) {
        // Enable vertex-array and define its buffer
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);          // Enable color-array (NEW)
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);  // Define color-array buffer (NEW)

        //define vertex array via glvertex pointer
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        // Draw the primitives from the vertex-array directly
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 3);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);   // Disable color-array (NEW)
    }
}

