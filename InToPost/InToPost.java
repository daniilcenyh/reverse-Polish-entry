package InToPost;

import StackX.StackX;

public class InToPost {
    // инициализация переменных
    private StackX the_stack;
    private String input;
    private String output = "";

    // конструтор класса InToPost
    public InToPost(String in) {
        input = in;
        int stack_size = input.length();
        the_stack = new StackX(stack_size);
    }

    /**
     * пребразование входной строки в постфиксную форму
     * @return output
     */
    public String do_transform_in_postfix_form() {

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            the_stack.display_stack("for " + ch + " "); // диагностика
            switch(ch) {
                case '+':
                case '-':
                    got_oper(ch,1);
                    break;
                case '*':
                case '/':
                    got_oper(ch,2);
                    break;
                case '(':
                    the_stack.push(ch);
                    break;
                case ')':
                    got_paren(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }

        while (!the_stack.is_empty()) { // извлечение оставшихся элементов
            the_stack.display_stack("While ");
            output = output + the_stack.pop();
        }
        the_stack.display_stack("END  ");

        return output;
    }

    public void got_oper(char op_this, int prec_1) { // чтение оператора из входной строки
        while (!the_stack.is_empty()) {
            char op_top = the_stack.pop();
            if (op_top == '(') {
                the_stack.push(op_top);
                break;
            } else {
                int prec_2; // приоритет нового оператора
                if ((op_top == '+') || (op_top == '-')) { // определение приоритета
                    prec_2 = 1;
                } else {
                    prec_2 = 2;
                }
                // если приоритет нового оператора меньше приоритета старого --> Сохранить новый оператор
                if (prec_2 < prec_1) {
                    the_stack.push(op_top);
                    break;
                } else { // приоритет нового оператора не меньше приоритета старого
                    output = output + op_top;
                }
            }

            the_stack.push(op_this);
        }
    }

    public void got_paren(char ch) {
        while (!the_stack.is_empty()) {
            char chx = the_stack.pop();
            if (chx == '(') {
                break;
            } else {
                output = output + chx;
            }
        }
    }
}
