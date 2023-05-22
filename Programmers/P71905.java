public class P71905 {
    private static String skill = "CBD";
    private static String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

    public static void main(String[] args) {
        int count = 0;

        for(String str : skill_trees){
            String thisStr = deleteOthers(str);
            int[] tmpArray = new int[thisStr.length()];

            for(int i = 0 ; i < tmpArray.length; i++){
                tmpArray[i] = skill.indexOf(thisStr.charAt(i));
            }

            boolean possible = true;
            for(int i = 0; i < tmpArray.length; i++){
                if(i != tmpArray[i]){
                    possible = false;
                    break;
                }
            }

            if(possible) count++;
        }

        System.out.println(count);
    }

    private static String deleteOthers(String str){
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (skill.contains(String.valueOf(c)) && sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
