import com.company.UnitConversionTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Universidade Positivo 2018
 * Pós em Teste de Software
 * Automação de Testes
 * @author Dener Alves de Campos | Matrícula:1813379
 */

/**
 * Testes Unitários para converter tempo
 * Lembrando que:
 *
 * 1 MINUTO = 60 SEGUNDOS
 * 1 HORA = 60 MINUTOS
 *
 */
public class UnitConversionTimeTest {

    private UnitConversionTime uTime;
    private double time;

    @Before
    public void init(){
        this.uTime = new UnitConversionTime();
        this.time = 0;
    }

    @Test
    public void testInvalidTime()
    {
        this.time = -56;
        Assert.assertFalse(uTime.isValidTime(this.time));
    }

    @Test
    public void testValidTime(){
        this.time = 789;
        Assert.assertTrue(uTime.isValidTime(this.time));
    }

    @Test
    public void testCalculateSecondsToMinute()
    {
        this.time = 567;
        Assert.assertEquals(9.45,uTime.calcSecondsToMinutes(time),0.01);
    }

    @Test
    public void testCalculateSecondsToHour(){
        this.time = 6780;
        Assert.assertEquals(1.88,uTime.calcSecondsToHours(time),0.01);
    }

    @Test
    public void testCalculateMinutesToHour(){
        this.time = 240;
        Assert.assertEquals(4.00,uTime.calcMinutesToHours(time),0.01);
    }

    @Test
    public void testMinutesToSeconds(){
        this.time = 45;
        Assert.assertEquals(2700.00,uTime.calcMinutesToSeconds(time),0.01);
    }

    @Test
    public void testCalculateHoursToSeconds(){
        this.time = 3;
        Assert.assertEquals(10800.00,uTime.calcHoursToSeconds(time),0.01);
    }

    @Test
    public void testCalculateHoursToMinutes(){
        this.time = 8;
        Assert.assertEquals(480.00,uTime.calcMinutesToSeconds(time),0.01);
    }
}
