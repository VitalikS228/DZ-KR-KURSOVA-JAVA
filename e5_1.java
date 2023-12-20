import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return word;
    }
}

class Sentence {
    private List<Word> words;

    public Sentence() {
        this.words = new ArrayList<>();
    }

    public void add_word(Word word) {
        words.add(word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(words, sentence.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Word word : words) {
            sentence.append(word).append(" ");
        }
        return sentence.toString().trim();
    }
}

class Text {
    private List<Sentence> sentences;
    private String title;

    public Text(String title) {
        this.title = title;
        this.sentences = new ArrayList<>();
    }

    public void add_sentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public void display_text() {
        System.out.println("Title: " + title);
        for (Sentence sentence : sentences) {
            System.out.println(sentence);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Text text = (Text) o;
        return Objects.equals(sentences, text.sentences) &&
                Objects.equals(title, text.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentences, title);
    }

    @Override
    public String toString() {
        StringBuilder textString = new StringBuilder();
        textString.append("Title: ").append(title).append("\n");
        for (Sentence sentence : sentences) {
            textString.append(sentence).append("\n");
        }
        return textString.toString();
    }
}

public class e5_1 {
    public static void main(String[] args) {
        Word word1 = new Word("This"); // word objects
        Word word2 = new Word("is");
        Word word3 = new Word("my");
        Word word4 = new Word("text");

        Sentence sentence1 = new Sentence(); // sentence object
        sentence1.add_word(word1);
        sentence1.add_word(word2);
        sentence1.add_word(word3);
        sentence1.add_word(word4);

        System.out.println("Sentence toString(): " + sentence1.toString()); // print sentence

        Sentence sentence2 = new Sentence(); // sentence test
        sentence2.add_word(new Word("This"));
        sentence2.add_word(new Word("is"));
        sentence2.add_word(new Word("my"));
        sentence2.add_word(new Word("text"));

        System.out.println("Equals(): " + sentence1.equals(sentence2));

        Text text = new Text("This is my title"); // adding sentence to text object
        text.add_sentence(sentence1);

        System.out.println("\nText toString():\n" + text.toString());

        Text text2 = new Text("This is my title");
        text2.add_sentence(sentence2);

        System.out.println("Equals(): " + text.equals(text2));

        System.out.println("\nDisplay Text:"); // print text
        text.display_text();
        System.out.println("");
    }
}
