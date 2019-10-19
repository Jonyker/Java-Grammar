package com.wukj.tools.compress;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/1/21.
 */
public class CompressionUtil {
    private static final int BUFFER_SIZE = 1024;

    /**
     * compress data by {@linkplain Level}
     *
     * @param data
     * @param level see {@link Level}
     * @return
     * @throws IOException
     */
    public static byte[] compress(byte[] data, Level level) throws IOException {

        Deflater deflater = new Deflater();
        deflater.setLevel(level.getLevel());
        deflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        deflater.finish();
        byte[] buffer = new byte[BUFFER_SIZE];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer); // returns the generated
            outputStream.write(buffer, 0, count);
        }
        byte[] output = outputStream.toByteArray();
        outputStream.close();
        return output;
    }

    /**
     * decompress data
     *
     * @param data
     * @return
     * @throws IOException
     * @throws DataFormatException
     */
    public static byte[] decompress(byte[] data) throws IOException, DataFormatException {


        Inflater inflater = new Inflater();
        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[BUFFER_SIZE];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        byte[] output = outputStream.toByteArray();
        outputStream.close();
        return output;
    }

    /**
     * Compression level
     */
    public static enum Level {

        /**
         * Compression level for no compression.
         */
        NO_COMPRESSION(0),

        /**
         * Compression level for fastest compression.
         */
        BEST_SPEED(1),

        /**
         * Compression level for best compression.
         */
        BEST_COMPRESSION(9),

        /**
         * Default compression level.
         */
        DEFAULT_COMPRESSION(-1);

        private int level;

        Level(

                int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }
}
