package fr.oreo.modernClaims.api.domain.model;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public record ClaimDefinition(
        UUID id,
        String name,
        UUID ownerId,
        String world,
        Set<ClaimChunk> chunks,
        String status,
        double taxRate,
        UUID townId,
        UUID nationId,
        Map<UUID, String> memberRoles
) {
    public ClaimDefinition {
        chunks = chunks == null ? Set.of() : Set.copyOf(new LinkedHashSet<>(chunks));
        memberRoles = memberRoles == null ? Map.of() : Map.copyOf(new LinkedHashMap<>(memberRoles));
    }

    public int chunkCount() {
        return chunks.size();
    }
}
