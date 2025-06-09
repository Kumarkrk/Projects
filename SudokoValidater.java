import java.util.*;
import java.util.Set;
public class SudokoValidater {
    public static boolean isValidSudoku(char[][] board, List<List<int[]>> customZones) {
    for (int i = 0; i < 9; i++) {
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            if (board[i][j] != '.' && !row.add(board[i][j])) return false;
            if (board[j][i] != '.' && !col.add(board[j][i])) return false;
        }
    }

    for (int block = 0; block < 9; block++) {
        Set<Character> blockSet = new HashSet<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                char ch = board[3 * (block / 3) + i][3 * (block % 3) + j];
                if (ch != '.' && !blockSet.add(ch)) return false;
            }
    }

    for (List<int[]> zone : customZones) {
        Set<Character> zoneSet = new HashSet<>();
        for (int[] pos : zone) {
            char ch = board[pos[0]][pos[1]];
            if (ch != '.' && !zoneSet.add(ch)) return false;
        }
    }

    return true;
}
 public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        // System.out.println(board[0].length);

        List<List<int[]>> customZones = new ArrayList<>();
        customZones.add(Arrays.asList(new int[][]{{0,0},{0,1},{1,0},{1,1},{2,0},{2,1},{3,0},{3,1},{4,0}}));

        System.out.println("Is valid: " + isValidSudoku(board, customZones));
    }

    
}
