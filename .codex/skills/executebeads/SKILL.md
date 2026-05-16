---
name: executebeads
description: implement all ready beads in sequence
license: MIT
---

implement all ready beads, in sequence. Use a new subagent for each and make it commit after each bead is done.
Beads can be locked by other beads, so always run `bd ready` before starting a new one and pick the first. If no ready beads are left after all subagents completed you're done
