
//Method 3
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        int numOfStr = strs.size();
        List<Integer> lengths = new LinkedList<Integer>();
        for (String s:strs) {
            lengths.add(s.length());
        }
        String result = numOfStr + "";
        for (Integer i:lengths) {
            result +=":" + i;
        }
        result += ":";
        for (String s:strs) {
            result +=s;
        }
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new LinkedList<String>();
        int i = 0;
        int numOfStr = 0;
        while (s.charAt(i) != ':') {
            numOfStr = numOfStr * 10 + (s.charAt(i) - '0');
            i ++;
        }
        List<Integer> lengths = new LinkedList<Integer>();
        i ++;
        for (int j = 0; j < numOfStr; j ++) {
            int leng = 0;
            while (s.charAt(i) != ':') {
                leng = leng * 10 + (s.charAt(i) - '0');
                i ++;
            }
            lengths.add(leng);
            i ++;
        }
        for (Integer l:lengths) {
            String tmp = "";
            for (int j = 0; j < l; j ++) {
                tmp +=s.charAt(i);
                i ++;
            }
            result.add(tmp);
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));

// Method 2
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }
}


// Method 1
public class Codec {
 
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
         
        for (String str : strs) {
            if (str == null || str.length() == 0) {
                sb.append("0#");
            } else {
                sb.append(str.length() + "#" + str);
            }
        }
         
        return sb.toString();
    }
 
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
         
        if (s == null || s.length() == 0) {
            return strs;
        }
         
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                j++;
            }
             
            int num = Integer.parseInt(s.substring(i, j));
            i = j;
            i++; // skip '#'
            if (num == 0) {
                strs.add("");
            } else {
                strs.add(s.substring(i, i + num));
            }
             
            i += num;
        }
         
        return strs;
    }
}
 
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
