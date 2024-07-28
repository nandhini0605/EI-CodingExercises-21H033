// Product interface
interface Document {
    void open();
}

// Concrete products
class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document.");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document.");
    }
}

class TextDocument implements Document {
    public void open() {
        System.out.println("Opening Text document.");
    }
}

// Creator class
abstract class DocumentCreator {
    public abstract Document createDocument();

    public void openDocument() {
        Document doc = createDocument();
        doc.open();
    }
}

// Concrete creators
class WordDocumentCreator extends DocumentCreator {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentCreator extends DocumentCreator {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class TextDocumentCreator extends DocumentCreator {
    public Document createDocument() {
        return new TextDocument();
    }
}

// Main class to test the pattern
public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        DocumentCreator wordCreator = new WordDocumentCreator();
        DocumentCreator pdfCreator = new PdfDocumentCreator();
        DocumentCreator textCreator = new TextDocumentCreator();

        wordCreator.openDocument();
        pdfCreator.openDocument();
        textCreator.openDocument();
    }
}
