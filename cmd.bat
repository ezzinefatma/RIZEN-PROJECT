wmic cpu get  name /all >pi.txt
wmic path win32_VideoController get name /all >> pi.txt
wmic MemoryChip get  Capacity, MemoryType, Speed /all >> pi.txt