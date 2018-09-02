import com.company.UnitConversionSpeed;
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
 * Testes Unitários para converter velocidade
 * Lembrando que:
 *
 * 1 km/h  = 0.27 m/s
 * 1 m/s = 3.6 km/h
 *
 */
public class UnitConversionSpeedTest {

    private UnitConversionSpeed uSpeed;
    private double speed;

    @Before
    public void init(){
        this.uSpeed = new UnitConversionSpeed();
        this.speed = 0;
    }

    @Test
    public void testInvalidSpeed()
    {
        this.speed = -56;
        Assert.assertFalse(uSpeed.isValidSpeed(this.speed));
    }

    @Test
    public void testValidSpeed(){
        this.speed = 789;
        Assert.assertTrue(uSpeed.isValidSpeed(this.speed));
    }

    @Test
    public void testCalculateMeterSecondsToKilometersHour()
    {
        this.speed = 1;
        Assert.assertEquals(3.60,uSpeed.calculateMeterSecondsToKilometersHour(speed),0.01);
    }

    @Test
    public void testCalculateKilometersHourToMeterSeconds(){
        this.speed = 36;
        Assert.assertEquals(10.00,uSpeed.calculateKilometersHourToMeterSeconds(speed),0.01);
    }

}
