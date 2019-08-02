

package exception;

import java.nio.file.Path;


/**
 * Shows non-parsed data in specific row by given file path.
 */
public class FileParsingException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 0L;

    /**
     * Creates new exception.
     *
     * @param parsedData Data to parse.
     * @param rowIdx     Index of row in file.
     * @param file       File path
     */
    public FileParsingException(String parsedData, int rowIdx, Path file) {
        super("Data " + parsedData + " in row # " + rowIdx + " in file " + file + " can not be parsed to appropriate format");
    }
}
