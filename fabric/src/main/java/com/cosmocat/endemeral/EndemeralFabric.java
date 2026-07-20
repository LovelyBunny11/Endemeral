package com.cosmocat.endemeral;

import com.cosmocat.endemeral.Endemeral;
import net.fabricmc.api.ModInitializer;

public class EndemeralFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Endemeral.init();
    }
}
