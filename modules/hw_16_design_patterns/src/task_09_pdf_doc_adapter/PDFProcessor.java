package task_09_pdf_doc_adapter;

public class PDFProcessor implements DocumentProcessor {
    @Override
    public void process(String fileName) {
        if (!fileName.toLowerCase().endsWith(".pdf")) {
            throw new IllegalArgumentException("Ожидается PDF-файл: " + fileName);
        }
        System.out.println("Обрабатываю PDF-документ: " + fileName);
    }
}
