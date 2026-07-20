package com.cosmocat.endemeral;


import com.cosmocat.endemeral.Endemeral;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Endemeral.MOD_ID)
public class EndemeralNeoforge {

    public EndemeralNeoforge(IEventBus eventBus) {
        Endemeral.init();
    }
}