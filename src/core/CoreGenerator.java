package core;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

public class CoreGenerator {
    public void generateQR(String URL, String filePath, int width, int height, String format) {
        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(URL, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToPath(bitMatrix, format, new File(filePath).toPath());
        } catch (WriterException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
