public class Satisfactory {
    public static boolean isSatisfactory(boolean good, boolean fast, boolean cheap) {
        if ((good && fast) || (good && cheap) || (fast && cheap)){
            return true;
        }
        return false;
    }

    public static boolean isSatisfactoryRefactored(boolean good, boolean fast, boolean cheap) {
        if (good && fast){
            return true;
        }
        if (good && cheap){
            return true;
        }
        if (fast && cheap){
            return true;
        }
        return false;
    }
}
