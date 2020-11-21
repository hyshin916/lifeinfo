package kr.co.mseshop.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private int min;
    private int max;
    private boolean nullable;


    @Override
    public void initialize(Password passwordValidator) {
        //어노테이션 등록 시, 입력했던 Parameter를 초기화한다.
        min = passwordValidator.min();
        max = passwordValidator.max();
        nullable = passwordValidator.nullable();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        //if password is not blank
        if (StringUtils.hasText(password)) {
            if (password.length() < min || password.length() > max) {
                addConstraintViolation(
                        context,
                        String.format("비밀번호는 %d자 ~ %d자 사이로 입력해주세요.", min, max)
                );
                return false;
            }
        } 
        else if (!nullable){
            addConstraintViolation(
                    context,
                    "비밀번호를 입력해주세요."
            );
            return false;
        }

        return true;
    }

    private void addConstraintViolation(ConstraintValidatorContext context, String msg) {
        //기본 메시지 비활성화
        context.disableDefaultConstraintViolation();
        //새로운 메시지 추가
        context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
    }

}