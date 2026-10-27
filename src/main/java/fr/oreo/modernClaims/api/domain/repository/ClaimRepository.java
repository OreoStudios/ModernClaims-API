package fr.oreo.modernClaims.api.domain.repository;

import fr.oreo.modernClaims.api.domain.model.Claim;
import fr.oreo.modernClaims.api.domain.model.ClaimDefinition;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ClaimRepository {

    Collection<Claim> findAll();

    Optional<Claim> findById(UUID id);

    Optional<Claim> findByName(String name);

    Collection<Claim> findByOwner(UUID ownerId);

    Optional<Claim> findByChunk(String world, int chunkX, int chunkZ);

    Claim create(ClaimDefinition definition);

    Claim update(UUID id, ClaimDefinition definition);

    boolean delete(UUID id);
}
