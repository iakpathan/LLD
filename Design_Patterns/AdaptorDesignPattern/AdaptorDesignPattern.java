package Design_Patterns.AdaptorDesignPattern;


    // Target Interface: Universal Remote
interface UniversalRemote {
    void turnonPower();
}

// Adaptee: TV device
class TV {
    public void tvon() {
        System.out.println("TV is Powered on using Universal Remote");
    }
}

// Adaptee: AC device
class AC {
    public void acon() {
        System.out.println("AC is Powered on using Universal Remote");
    }
}

// Adapter for TV
class TvAdaptor implements UniversalRemote {
    private TV tvremote;

    public TvAdaptor(TV tvremote) {
        this.tvremote = tvremote;
    }

    @Override
    public void turnonPower() {
        tvremote.tvon();
    }
}

// Adapter for AC
class AcAdaptor implements UniversalRemote {
    private AC acremote;

    public AcAdaptor(AC acremote) {
        this.acremote = acremote;
    }

    @Override
    public void turnonPower() {
        acremote.acon();
    }
}

// Client Code
public class AdaptorDesignPattern {
    public static void main(String[] args) {
        // Create instances of devices
        TV myTv = new TV();
        AC myAc = new AC();

        // Create adapters
        UniversalRemote tvAdapter = new TvAdaptor(myTv);
        UniversalRemote acAdapter = new AcAdaptor(myAc);

        // Use Universal Remote to turn on devices
        tvAdapter.turnonPower();
        acAdapter.turnonPower();
    }
}

