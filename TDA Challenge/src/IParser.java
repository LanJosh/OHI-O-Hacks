import java.util.ArrayList;
import java.io.File;
/*
 * Interface for job and student file parsers
 *
 * 1347 Joshua Lan
 */
public interface IParser {
    public ArrayList<String[]> parse(File data);
}
