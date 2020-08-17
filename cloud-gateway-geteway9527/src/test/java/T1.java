import org.junit.Test;

import java.time.ZonedDateTime;

/**
*********************************************************************
* 
* @author poles
* @date 2020/8/14 5:29 下午
*
*********************************************************************
*/
public class T1 {
    @Test
    public void getNowWithZone(){
        ZonedDateTime zdt = ZonedDateTime.now();        //默认时区，java8新出的
        System.out.println(zdt);
    }
}
