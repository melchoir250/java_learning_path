package task_09_pdf_doc_adapter;

public class Main {
    public static void main(String[] args) {
        DOCProcessor docProcessor = new DOCProcessor();
        DocumentProcessor adapter = new DocumentAdapter(docProcessor);

        adapter.process("contract.doc");
        System.out.println();
        adapter.process("report.pdf");
    }
}
