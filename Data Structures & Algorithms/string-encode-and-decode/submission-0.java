class Solution {
    final char DELIMITER ='#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str.length());
            sb.append(DELIMITER);
            sb.append(str);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String>res = new LinkedList<>();
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length;i++){
            StringBuilder sb = new StringBuilder();
            while(arr[i] != DELIMITER){
                sb.append(arr[i++]);
            }
            i++;

            int numOfChars = Integer.valueOf(sb.toString());
            int end = i +numOfChars;
            sb = new StringBuilder();
            while(i<end){
                sb.append(arr[i++]);
            }
            i--;

            res.add(sb.toString());
        }
        return res;

    }
}
