package com.russellsite.russellsite.mathematics.simpleoperationapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

import static com.russellsite.russellsite.util.StringUtils.reverse;

@RestController
@RequestMapping("/operation")
@CrossOrigin
public class OperationController {

    private final HashMap<Long, String> radixToNum;

    public OperationController() {
        radixToNum = getRadixConversion();
    }

    @GetMapping("/add/{x}/{y}")
    public int add(@PathVariable int x, @PathVariable int y) {
        return x + y;
    }

    @GetMapping("/sub/{x}/{y}")
    public String sub(@PathVariable int x, @PathVariable int y) {
        return String.format("x = %d\ny = %d\nx - y = %d\ny - x = %d\n", x, y, x - y, y - x);
    }

    @GetMapping("/binary/{number}")
    public String binarise(@PathVariable long number) {
        StringBuilder stringBuilder = new StringBuilder();
        while (number > 0) {
            stringBuilder.append(number % 2);
            number /= 2;
        }
        String binary = stringBuilder.toString();
        return reverse(binary);
    }

    public HashMap<Long, String> getRadixConversion() {
        HashMap<Long, String> radixToNum = new HashMap<>();
        for (long i = 0; i < 10; i++) {
            radixToNum.put(i, String.valueOf(i));
        }

        radixToNum.put(10L, "A");
        radixToNum.put(11L, "B");
        radixToNum.put(12L, "C");
        radixToNum.put(13L, "D");
        radixToNum.put(14L, "E");
        radixToNum.put(15L, "F");

        return radixToNum;
    }

    @GetMapping("radix/{radix}/{number}")
    public String hexadecimalise(@PathVariable long number, @PathVariable long radix) {
        if (radix > 16 || radix < 2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Radix must be from 2 to 16");
        }
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Long, String> radixToNum = getRadixConversion();
        while (number > 0) {
            stringBuilder.append(radixToNum.get(number % radix));
            number /= radix;
        }
        return reverse(stringBuilder.toString());
    }

}
