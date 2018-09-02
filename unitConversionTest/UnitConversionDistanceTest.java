import com.company.UnitConversionDistance;
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
 * Testes Unitários para converter distancia
 * Lembrando que:
 *
 * 1 m = 100cm
 * 1 km = 1000m
 *
 */
public class UnitConversionDistanceTest {

    private UnitConversionDistance uDistance;
    private double distance;

    @Before
    public void init(){
        this.uDistance = new UnitConversionDistance();
        this.distance = 0;
    }

    @Test
    public void testInvalidSpeed()
    {
        this.distance = -56;
        Assert.assertFalse(uDistance.isValidDistance(this.distance));
    }

    @Test
    public void testValidSpeed(){
        this.distance = 789;
        Assert.assertTrue(uDistance.isValidDistance(this.distance));
    }

    @Test
    public void testCalculateMetersToCentimeters()
    {
        this.distance = 17;
        Assert.assertEquals(1700.00,uDistance.calculateMetersToCentimeters(this.distance),0.01);
    }

    @Test
    public void testCalculateKilometersToMeters(){
        this.distance = 89;
        Assert.assertEquals(89000.00,uDistance.calculateKilometersToMeters(this.distance),0.01);
    }
}
