import InToPost.InToPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Testing {

    public static String get_string() throws  IOException {
        InputStreamReader input_stream_reader = new InputStreamReader(System.in);
        BufferedReader buffered_reader = new BufferedReader(input_stream_reader);
        String string = buffered_reader.readLine();

        return string;
    }

    public static void main(String[] args) throws IOException {
        String output, input;
        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = get_string();

            if (input.equals("")) {
                break;
            }

            InToPost the_trans = new InToPost(input);
            output = the_trans.do_transform_in_postfix_form();
            System.out.println("Postfix is " + output + '\n');
        }
    }
}
