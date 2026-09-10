public class CustomerNameReverser {
    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversed = reverseCustomerName(customerName);
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversed);
    }

    public static String reverseCustomerName(String customerName) {
        char[] charArray = customerName.toCharArray();
        StringBuilder reversed = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            reversed.append(charArray[i]);
        }
        return reversed.toString();
    }
}