package com.implemica.bormashenko.calculator.view.util;

import com.implemica.bormashenko.calculator.view.View;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * This class allows to save information of view to file.
 *
 * @author Mykhailo Bormashenko
 */
public class SerializationView {

    /**
     * Path to dat file.
     */
    private static final String FILE_PATH = "src/main/java/com/implemica/bormashenko/calculator/view/resources/dat/view.dat";

    /**
     * Serializes View object.
     *
     * @param view object to save.
     */
    public static void saveView(View view) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
