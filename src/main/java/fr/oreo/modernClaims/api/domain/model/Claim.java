package fr.oreo.modernClaims.api.domain.model;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface Claim {

    UUID id();

    String name();

    UUID ownerId();

    String world();

    Set<ClaimChunk> chunks();

    default int chunkCount() {
        return chunks().size();
    }

    String status();

    double taxRate();

    UUID townId();

    UUID nationId();

    Map<UUID, String> memberRoles();
}
