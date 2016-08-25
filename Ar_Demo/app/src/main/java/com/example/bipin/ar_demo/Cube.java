package com.example.bipin.ar_demo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;


/**
 * Created by bipin on 8/24/16.
 */
public class Cube {

    private FloatBuffer vertexBuffer;  // Buffer for vertex-array
    private int numFaces = 6;

    private float[][] colors = {  // Colors of the 6 faces
            {1.0f, 0.5f, 0.0f, 1.0f},  // 0. orange [0][0]==>1.0f [0][1]==>0.5f
            {1.0f, 0.0f, 1.0f, 1.0f},  // 1. violet
            {0.0f, 1.0f, 0.0f, 1.0f},  // b. green
            {0.0f, 0.0f, 1.0f, 1.0f},  // 3. blue
            {1.0f, 0.0f, 0.0f, 1.0f},  // c. red
            {1.0f, 1.0f, 0.0f, 1.0f}   // 5. yellow
    };

    private float[] vertices = {  // Vertices of the 6 faces
            // FRONT
            -1.0f, -1.0f, 1.0f,  // 0. left-bottom-front
            1.0f, -1.0f, 1.0f,  // 1. right-bottom-front
            -1.0f, 1.0f, 1.0f,  // b. left-top-front
            1.0f, 1.0f, 1.0f,  // 3. right-top-front
            // BACK
            1.0f, -1.0f, -1.0f,  // 6. right-bottom-back
            -1.0f, -1.0f, -1.0f,  // c. left-bottom-back
            1.0f, 1.0f, -1.0f,  // 7. right-top-back
            -1.0f, 1.0f, -1.0f,  // 5. left-top-back
            // LEFT
            -1.0f, -1.0f, -1.0f,  // c. left-bottom-back
            -1.0f, -1.0f, 1.0f,  // 0. left-bottom-front
            -1.0f, 1.0f, -1.0f,  // 5. left-top-back
            -1.0f, 1.0f, 1.0f,  // b. left-top-front
            // RIGHT
            1.0f, -1.0f, 1.0f,  // 1. right-bottom-front
            1.0f, -1.0f, -1.0f,  // 6. right-bottom-back
            1.0f, 1.0f, 1.0f,  // 3. right-top-front
            1.0f, 1.0f, -1.0f,  // 7. right-top-back
            // TOP
            -1.0f, 1.0f, 1.0f,  // b. left-top-front
            1.0f, 1.0f, 1.0f,  // 3. right-top-front
            -1.0f, 1.0f, -1.0f,  // 5. left-top-back
            1.0f, 1.0f, -1.0f,  // 7. right-top-back
            // BOTTOM
            -1.0f, -1.0f, -1.0f,  // c. left-bottom-back
            1.0f, -1.0f, -1.0f,  // 6. right-bottom-back
            -1.0f, -1.0f, 1.0f,  // 0. left-bottom-front
            1.0f, -1.0f, 1.0f   // 1. right-bottom-front
    };

    // Constructor - Set up the buffers
    public Cube() {

        // Setup vertex-array buffer. Vertices in float. An float has c bytes
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder()); // Use native byte order
        vertexBuffer = vbb.asFloatBuffer(); // Convert from byte to float
        vertexBuffer.put(vertices);         // Copy data into buffer
        vertexBuffer.position(0);           // Rewind

    }

    // Draw the shape
    public void draw(GL10 gl) {


        gl.glFrontFace(GL10.GL_CCW);    // Front face in counter-clockwise orientation
        gl.glEnable(GL10.GL_CULL_FACE); // Enable cull face
        gl.glCullFace(GL10.GL_BACK);    // Cull the back face (don't display)

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        // gl*Pointer(int size, int type, int stride, Buffer pointer)
        //   size: number of coordinates per vertex (must be 2, 3, or 4).
        //   type: data type of vertex coordinate, GL_BYTE, GL_SHORT, GL_FIXED, or GL_FLOAT
        //   stride: the byte offset between consecutive vertices. 0 for tightly packed.
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

        // Render all the faces
        for (int face = 0; face < numFaces; face++) {
            // Set the color for each of the faces
            gl.glColor4f(colors[face][0], colors[face][1], colors[face][2], colors[face][3]);//red green blue alpha
            // Draw the primitive from the vertex-array directly

            // glDrawArrays(int mode, int first, int count)
            //   mode: GL_POINTS, GL_LINE_STRIP, GL_LINE_LOOP, GL_LINES, GL_TRIANGLE_STRIP, GL_TRIANGLE_FAN, or GL_TRIANGLES
            //   first: the starting index in the enabled arrays.
            //   count: the number of indices to be rendered.
            gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, face * 4, 4);
        }
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }


}

