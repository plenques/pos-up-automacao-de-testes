import com.company.UnitConversionTemperature;
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
 * Testes Unitários para conversão de unidade
 * Lembrando que:
 *
 * CELSIUS TO KELVIN = CELSIUS + 273.15;
 * KELVIN TO CELSIUS = KELVIN - 273.15;
 *
 * CELSIUS TO FAHRENHEIT = 1.8 * CELSIUS + 32
 * FAHRENHEIT TO CELSIUS = FAHRENHEIT - 32 / 1.8
 *
 * KELVIN TO FAHRENHEIT = 1.8 * (KELVIN - 273.15) + 32
 * FAHRENHEIT TO KELVIN = (FAHRENHEIT - 32)/ 1.8 + 273.15
 *
 */

public class UnitConversionTemperatureTest {

    private UnitConversionTemperature uc;
    private double temperature;
    private String initialUnit;
    private String finalUnit;

    @Before
    public void init(){
        this.uc = new UnitConversionTemperature();
        this.temperature = 0;
        this.initialUnit = "";
        this.finalUnit = "";
    }

    @Test
    public void testValidUnitKelvinSuccess()
    {
        this.initialUnit = "KELVIN";
        Assert.assertTrue(uc.isValidUnits(this.initialUnit));

    }

    @Test
    public void testValidUnitCelsiusSuccess()
    {
        this.initialUnit = "CELSIUS";
        Assert.assertTrue(uc.isValidUnits(this.initialUnit));

    }

    @Test
    public void testValidUnitFahrenheitSuccess()
    {
        this.initialUnit = "FAHRENHEIT";
        Assert.assertTrue(uc.isValidUnits(this.initialUnit));

    }

    @Test
    public void testValidUnitError()
    {
        this.initialUnit = "HEUEHUEHEUEHU";
        Assert.assertFalse(uc.isValidUnits(this.initialUnit));

    }

    @Test
    public void testLowestValuePossibleForKelvinTemperatureSuccess()
    {
        this.temperature = 16;
        Assert.assertTrue(uc.isValidTemperature(this.temperature,"KELVIN"));
    }

    @Test
    public void testLowestValuePossibleForKelvinTemperatureError()
    {
        this.temperature = -90;
        Assert.assertFalse(uc.isValidTemperature(this.temperature,"KELVIN"));

    }

    @Test
    public void testLowestValuePossibleForCelsiusTemperatureSuccess()
    {
        this.temperature = 1800;
        Assert.assertTrue(uc.isValidTemperature(this.temperature,"CELSIUS"));
    }

    @Test
    public void testLowestValuePossibleForCelsiusTemperatureError()
    {
        this.temperature = -280;
        Assert.assertFalse(uc.isValidTemperature(this.temperature,"CELSIUS"));
    }

    @Test
    public void testLowestValuePossibleForFahrenheitTemperatureSuccess()
    {
        this.temperature = 1555;
        Assert.assertTrue(uc.isValidTemperature(this.temperature,"FAHRENHEIT"));
    }

    @Test
    public void testLowestValuePossibleForFahrenheitTemperatureError()
    {
        this.temperature = -591;
        Assert.assertFalse(uc.isValidTemperature(this.temperature,"FAHRENHEIT"));
    }

    @Test
    public void testCalculateCelsiusToKelvinSuccess()
    {
        this.temperature = 12;
        this.initialUnit = "CELSIUS";
        this.finalUnit = "KELVIN";
        Assert.assertEquals(285.15,uc.calcTemp(this.temperature,this.initialUnit,this.finalUnit),0.01);
    }

    @Test
    public void testCalculateKelvinToCelsiusSuccess()
    {
        this.temperature = 329.17;
        this.initialUnit = "KELVIN";
        this.finalUnit = "CELSIUS";
        Assert.assertEquals(56.02,uc.calcTemp(this.temperature,this.initialUnit,this.finalUnit),0.01);
    }

    @Test
    public void testCalculateCelsiusToFahrenheitSuccess()
    {
        this.temperature = 45.18;
        this.initialUnit = "CELSIUS";
        this.finalUnit = "FAHRENHEIT";
        Assert.assertEquals(113.32,uc.calcTemp(this.temperature,this.initialUnit,this.finalUnit),0.01);
    }

    @Test
    public void testCalculateKelvinToFahrenheitSuccess()
    {
        this.temperature = 125;
        this.initialUnit = "KELVIN";
        this.finalUnit = "FAHRENHEIT";
        Assert.assertEquals(-234.67,uc.calcTemp(this.temperature,this.initialUnit,this.finalUnit),0.01);
    }

    @Test
    public void testCalculateFahrenheitToKelvinSuccess()
    {
        this.temperature = -234.67;
        this.initialUnit = "FAHRENHEIT";
        this.finalUnit = "KELVIN";
        Assert.assertEquals(125,uc.calcTemp(this.temperature,this.initialUnit,this.finalUnit),0.01);
    }

    @Test
    public void testShowConvertResultSuccess()
    {
        this.temperature = -234.67;
        this.initialUnit = "FAHRENHEIT";
        this.finalUnit = "KELVIN";
        Assert.assertEquals("Valor "+this.initialUnit+" ("+String.format("%.2f",this.temperature)+") para "+this.finalUnit+" (125.00)",uc.showConvertResult(this.temperature,this.initialUnit,this.finalUnit));
    }

    @Test
    public void testShowConverResultError(){
        this.temperature = -280;
        this.initialUnit = "CELSIUS";
        this.finalUnit = "FAHRENHEIT";
        Assert.assertEquals("Nao foi possivel realizar a conversão, pois a temperatura inicial é inválida em "+this.initialUnit,uc.showConvertResult(this.temperature,this.initialUnit,this.finalUnit));

    }

    @Test
    public void testShowConvertResultUnitNameError()
    {
        this.temperature = -280;
        this.initialUnit = "CELSIUS";
        this.finalUnit = "FAHRENgyuguguHEIT";
        Assert.assertEquals("Unidades inválidas. Valores aceitáveis em maiúsculo [CELSIUS,KELVIN,FAHRENHEIT]!",uc.showConvertResult(this.temperature,this.initialUnit,this.finalUnit));

    }
}
