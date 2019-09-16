
public enum VisibleSymptom {
	UNKNOWN(false),
	COLD (false),
    FLU (false),
    EBOLA (false),
    BROKEN_BONE (true),
    CHEST_PAIN (false),
    MIGRAINE(false),
    SPRAIN(true);
    
    
    public final boolean requireRadiology; 
    
    VisibleSymptom(boolean requireRadiology) {
        this.requireRadiology = requireRadiology;
    }
}
