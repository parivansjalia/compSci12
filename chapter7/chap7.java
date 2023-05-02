public class chap7 {
    public int findBestFit(int size1, int size2, int space) {
        int fit1, fit2;
        if (size1 <= space) {
            fit1 = size1;
        } else {
            fit1 = 0;
        }
        if (size2 <= space) {
            fit2 = size2;
        } else {
            fit2 = 0;
        }

        int result;
        if (size1 + size2 <= space) {
            result = 3;
        } else if (fit1 == 0 && fit2 == 0) {
            result = 0;
        } else {
            if (fit1 > fit2) {
                result = 1;
            } else {
                result = 2;
            }
        }

        return result;
    }
}
