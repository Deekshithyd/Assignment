
 class Palindrome {
   static  public void main(String args[])
  {
     StringBuilder s1=new StringBuilder("malayalam");
     StringBuilder s4=s1.reverse();
     
     if(s1.equals(s4))
     System.out.println("The string is palindrome");
     else
     System.out.println("The string is not a palindrome");
  }
}

