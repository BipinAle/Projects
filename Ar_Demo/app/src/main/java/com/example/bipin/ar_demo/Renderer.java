package com.example.bipin.ar_demo;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


/**
 * Created by bipin on 8/24/16.
 */
public class Renderer implements GLSurfaceView.Renderer {
    Triangle triangle;
    ColorSquare square;
    Cube cube;
    PhotoCube photoCube;
    Context context;
    TextureCube textureCube;

    // Rotational angle and speed (NEW)
    private float angleTriangle = 0.0f; // (NEW)
    private float angleQuad = 0.0f;     // (NEW)
    private float speedTriangle = 0.5f; // (NEW)
    private float speedQuad = 12.4f;    // (NEW)

    private float angleCube=0.0f;
    private float speedCube=4.0f;

    public Renderer(Context context) {
        this.context = context;
        triangle = new Triangle();
        square = new ColorSquare();
        textureCube=new TextureCube();
       // photoCube=new PhotoCube(context);
        cube = new Cube();


    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {// Called when the surface is first created or recreated. It can be used to perform one-time initialization tasks such as setting the clear-value for color and depth, enabling depth-test, etc.

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);  // Set color's clear-value to black
        gl.glClearDepthf(1.0f);            // Set depth's clear-value to farthest
        gl.glEnable(GL10.GL_DEPTH_TEST);   // Enables depth-buffer for hidden surface removal
        gl.glDepthFunc(GL10.GL_LEQUAL);    // The type of depth testing to do
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  // nice perspective view
        gl.glShadeModel(GL10.GL_SMOOTH);   // Enable smooth shading of color
        gl.glDisable(GL10.GL_DITHER);      // Disable dithering for better performance

        //   Setup Texture, each time the surface is created (NEW)
//        photoCube.loadTexture(gl);             // Load images into textures (NEW)
//        gl.glEnable(GL10.GL_TEXTURE_2D);  // Enable texture (NEW)




        // Setup Texture, each time the surface is created (NEW)
        textureCube.loadTexture(gl, context);    // Load image into Texture (NEW)
        gl.glEnable(GL10.GL_TEXTURE_2D);  // Enable texture (NEW)

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {//Called when the surface is first displayed and after window's size changes. It is used to set the view port and projection mode.
        if (height == 0) height = 1;   // To prevent divide by zero
        float aspect = (float) width / height;

        // Set the viewport (display area) to cover the entire window
        gl.glViewport(0, 0, width, height);

        // Setup perspective projection, with aspect ratio matches viewport
        gl.glMatrixMode(GL10.GL_PROJECTION); // Select projection matrix
        gl.glLoadIdentity();                 // Reset projection matrix
        // Use perspective projection
        GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f);

        gl.glMatrixMode(GL10.GL_MODELVIEW);  // Select model-view matrix
        gl.glLoadIdentity();    //reset
    }

    @Override
    public void onDrawFrame(GL10 gl) {

        // Clear color and depth buffers using clear-value set earlier
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();                 // Reset model-view matrix
//        gl.glTranslatef(0.0f, 1.0f, -7.0f); // Translate left and into the screen
//        gl.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);

//        gl.glRotatef(angleTriangle, 0.0f, 1.0f, 0.0f); // Rotate the triangle about the y-axis (NEW)
//        triangle.draw(gl);                   // Draw triangle
//

        gl.glTranslatef(0.0f, 0.0f, -8.0f);  // Translate right and into the screen (NEW)
        gl.glRotatef(angleCube, 1.0f, 1.0f, 0.0f); // Rotate the square about the x-axis (NEW)
       // square.draw(gl);

        // cube.draw(gl);
//
//        gl.glTranslatef(0.0f, 0.0f, -6.0f);   // Translate into the screen
//        gl.glRotatef(270.0f, 0.15f, 1.0f, 0.3f); // Rotate
//         photoCube.draw(gl);
        textureCube.draw(gl);


        // Update the rotational angle after each refresh (NEW)
        angleTriangle += speedTriangle; // (NEW)

        angleCube += speedCube;         // (NEW)





    }

}

