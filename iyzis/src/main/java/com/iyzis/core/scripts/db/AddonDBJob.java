package com.iyzis.core.scripts.db;

import com.iyzis.apps.addon.domain.AddonEntityBuilder;
import com.iyzis.apps.addon.domain.entity.Addon;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.ArrayList;
import java.util.List;

public class AddonDBJob implements DBJob {

    private List<Addon> addons = new ArrayList<>();
    MongoOperations dbOperation;

    public AddonDBJob(MongoOperations dbOperation) {
        this.dbOperation = dbOperation;

        dbOperation.dropCollection(Addon.class);

        AddonEntityBuilder entityBuilder = AddonEntityBuilder.newInstance();
        Addon addon1 = entityBuilder
                .id("1")
                .name("Addon 1")
                .description("Private Consultant")
                .price(500.00)
                .build();

        Addon addon2 = entityBuilder
                .id("2")
                .name("Addon 2")
                .description("7/24 Support")
                .price(750.00)
                .build();


        addons.add(addon1);
        addons.add(addon2);
    }


    @Override
    public void run() {
        this.addons.forEach(addon -> {
            this.dbOperation.insert(addon);
            System.out.println(addon.toString());
        });
    }
}
