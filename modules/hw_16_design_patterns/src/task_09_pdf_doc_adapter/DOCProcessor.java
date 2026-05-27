package task_09_pdf_doc_adapter;

public class DOCProcessor implements DocumentProcessor {
    @Override
    public void process(String fileName) {
        if (!fileName.toLowerCase().endsWith(".doc")) {
            throw new IllegalArgumentException("Ожидается DOC-файл: " + fileName);
        }
        System.out.println("Обрабатываю DOC-документ: " + fileName);
    }
}
