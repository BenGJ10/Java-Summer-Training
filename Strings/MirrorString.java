public class MirrorString {
    public static void main(String args[]){
        String str = "pppqqqwwq";
        StringBuilder sb = new StringBuilder();
        
        System.out.println("Normal image is: " + str);
        for(int i = str.length() - 1; i >= 0; i--){
            char ch = str.charAt(i);
            if(ch == 'q'){
                sb.append('p');
            }
            else if(ch == 'p'){
                sb.append('q');
            }
            else{
                sb.append('w');
            }
        }

        System.out.println("Mirror image is: " + sb.toString());
    }
}
