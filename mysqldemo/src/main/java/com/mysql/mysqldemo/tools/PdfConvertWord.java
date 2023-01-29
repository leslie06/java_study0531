package com.mysql.mysqldemo.tools;


import com.aspose.pdf.DocSaveOptions;
import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description
 * @Author leslie
 * @Date 2022/11/8 12:25
 **/
public class PdfConvertWord {
    private static final String _dataDir = "E:\\java电子书\\";
    public static void main(String[] args) throws IOException {
        ConvertPDFtoWord();
        ConvertPDFtoWordDocAdvanced();
    }

    public static void ConvertPDFtoWord() {
        // Open the source PDF document
        Document pdfDocument = new Document(_dataDir + "clean code-代码整洁之道 中文完整版-带书签.pdf");
        // Save the file into MS document format
        pdfDocument.save(_dataDir + "clean code-代码整洁之道 中文完整版-带书签.doc", SaveFormat.Doc);

    }
    public static void ConvertPDFtoWordDocAdvanced()
    {
        Path pdfFile = Paths.get(_dataDir.toString(), "clean code-代码整洁之道 中文完整版-带书签.pdf");
        Path docFile = Paths.get(_dataDir.toString(), "clean code-代码整洁之道 中文完整版-带书签.doc");
        Document pdfDocument = new Document(pdfFile.toString());
        DocSaveOptions saveOptions = new DocSaveOptions();

        // Specify the output format as DOC
        saveOptions.setFormat(DocSaveOptions.DocFormat.Doc);
        // Set the recognition mode as Flow
        saveOptions.setMode(DocSaveOptions.RecognitionMode.Flow);

        // Set the Horizontal proximity as 2.5
        saveOptions.setRelativeHorizontalProximity(2.5f);

        // Enable the value to recognize bullets during conversion process
        saveOptions.setRecognizeBullets(true);

        pdfDocument.save(docFile.toString(), saveOptions);
    }

}
