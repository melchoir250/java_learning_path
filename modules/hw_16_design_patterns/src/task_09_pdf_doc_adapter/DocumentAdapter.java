package task_09_pdf_doc_adapter;

public class DocumentAdapter implements DocumentProcessor {
    private final DOCProcessor docProcessor;

    public DocumentAdapter(DOCProcessor docProcessor) {
        this.docProcessor = docProcessor;
    }

    @Override
    public void process(String fileName) {
        if (fileName.toLowerCase().endsWith(".doc")) {
            docProcessor.process(fileName);
            return;
        }

        if (fileName.toLowerCase().endsWith(".pdf")) {
            String converted = convertPdfToDoc(fileName);
            docProcessor.process(converted);
            return;
        }

        throw new IllegalArgumentException("Поддерживаются только .pdf и .doc: " + fileName);
    }

    private String convertPdfToDoc(String pdfFileName) {
        String docFileName = pdfFileName.substring(0, pdfFileName.length() - 4) + ".doc";
        System.out.println("Конвертирую PDF -> DOC: " + pdfFileName + " -> " + docFileName);
        return docFileName;
    }
}
