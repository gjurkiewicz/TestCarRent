public class ParsePriceException extends Exception {
    @Override
    public String getMessage() {
        return "Podana cena jest nieprawidłowa!";
    }
}
