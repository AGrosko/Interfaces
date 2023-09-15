class ShortWordFilter implements Filter <String>{

public boolean accept(String x){

   return (x.length() < 5
           && !x.equals(".")
           && !x.equals(":")
           && !x.equals(",")
           && !x.equals("!")
           && !x.equals(" ")
           && !x.equals("?")
           && !x.equals(";"));
}

}
