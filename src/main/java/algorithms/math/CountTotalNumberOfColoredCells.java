package algorithms.math;


/**
 * 2579. Count Total Number of Colored Cells
 */
public class CountTotalNumberOfColoredCells {

    //1 5    13   25     41
    //1 1+4  5+8  13+12  25+16
    //    4    2*4   3*4    4*4  = (0+1+2+3+4+)*4
    public long coloredCells(int n) {
        return 1 + 4L * n * (n - 1) / 2;
    }

}
