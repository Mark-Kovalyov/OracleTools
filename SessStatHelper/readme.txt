Required stat names
===================

recursive calls 8
db block gets   66
consistent gets 70
physical reads  75
redo size       175
bytes sent via SQL*Net to client       579
bytes received via SQL*Net from client 580
SQL*Net roundtrips to/from client      581
sorts (memory)  589 
sorts (disk)    590
rows processed  (rows fetched via callback)  381

SessionStat{
 recursiveCalls=9418,
 dbBlockGets   =1105,
 consistentGets=81770,
 physicalReads =81353,
 redoSize      =209816,
 bytesSentViaSQLNetToClient=698,
 bytesReceivedViaSQLNetFromClient=319,
 SQLNetRoundtripsToFromClient=3,
 sortsMemory=370,
 sortsDisk=0,
 rowsProcessed=738
}


v$sesstat
=========


 Name                                                                                                      Null?    Type
 ----------------------------------------------------------------------------------------------------------------- --------
 SID                                                                                                                NUMBER
 STATISTIC#                                                                                                         NUMBER
 VALUE                                                                                                              NUMBER

v$statname
==========

 Name                                                                                                      Null?    Type
 ----------------------------------------------------------------------------------------------------------------- --------
 STATISTIC#                                                                                                         NUMBER
 NAME                                                                                                               VARCHAR2(64)
 CLASS                                                                                                              NUMBER
 STAT_ID                                                                                                            NUMBER

All stat names
==============

 STATISTIC# NAME                                                                  CLASS    STAT_ID
 ---------- ---------------------------------------------------------------- ---------- ----------
          0 OS CPU Qt wait time                                                       1  576270482
          1 logons cumulative                                                         1 2666645286
          2 logons current                                                            1 3080465522
          3 opened cursors cumulative                                                 1   85052502
          4 opened cursors current                                                    1 2301954928
          5 user commits                                                              1  582481098
          6 user rollbacks                                                            1 3671147913
          7 user calls                                                                1 2882015696
          8 recursive calls                                                           1 2656001462
          9 recursive cpu usage                                                       1 4009879262
         10 pinned cursors current                                                    1 2771133180
         11 session logical reads                                                     1 3143187968
         12 session logical reads in local numa group                                 1 1564026751
         13 session logical reads in remote numa group                                1 3011877906
         14 session stored procedure space                                            1  895486831
         15 CPU used when call started                                              128  572264820
         16 CPU used by this session                                                  1   24469293
         17 DB time                                                                   1 3649082374
         18 cluster wait time                                                         1 2432034337
         19 concurrency wait time                                                     1 3868577743
         20 application wait time                                                     1 1099569955
         21 user I/O wait time                                                        1 3332107451
         22 scheduler wait time                                                       1 2260360067
         23 non-idle wait time                                                        1 2498191658
         24 non-idle wait count                                                       1   45066233
         25 session connect time                                                      1 1678473874
         26 process last non-idle time                                              128 2049556447
         27 session uga memory                                                        1 1856888586
         28 session uga memory max                                                    1 3840343119
         29 messages sent                                                           128 2486045308
         30 messages received                                                       128 1396153242
         31 background timeouts                                                     128  961017212
         32 remote Oradebug requests                                                128 2605999124
         33 session pga memory                                                        1 4148600571
         34 session pga memory max                                                    1  507777907
         35 recursive system API invocations                                        128  728936273
         36 enqueue timeouts                                                          4 2425496215
         37 enqueue waits                                                             4 2307006529
         38 enqueue deadlocks                                                         4  472183780
         39 enqueue requests                                                          4 2440542518
         40 enqueue conversions                                                       4   57745673
         41 enqueue releases                                                          4 2553146675
         42 global enqueue gets sync                                                 32 1338475854
         43 global enqueue gets async                                                32 2892637759
         44 global enqueue get time                                                  32 3744090840
         45 global enqueue releases                                                  32 1516404026
         46 physical read total IO requests                                           8 3343375620
         47 physical read total multi block requests                                  8 2007302071
         48 physical read requests optimized                                          8 2481818206
         49 physical read total bytes optimized                                       8 2290009573
         50 physical read total bytes                                                 8 2572010804
         51 physical write total IO requests                                          8 1315894329
         52 physical write total multi block requests                                 8 3540174003
         53 physical write total bytes                                                8 2495644835
         54 cell physical IO interconnect bytes                                      64 2957355214
         55 spare statistic 1                                                       128  230898549
         56 spare statistic 2                                                       128 3818030889
         57 spare statistic 3                                                       128  686628667
         58 spare statistic 4                                                       128 3494279544
         59 IPC CPU used by this session                                             32 4247517299
         60 gcs messages sent                                                        32 2765451804
         61 ges messages sent                                                        32 1145425433
         62 global enqueue CPU used by this session                                  32 3469911798
         63 max cf enq hold time                                                      4 1032301310
         64 total cf enq hold time                                                    4 3653899408
         65 total number of cf enq holders                                            4  174183174
         66 db block gets                                                             8 1480709069
         67 db block gets from cache                                                  8 4017839461
         68 db block gets from cache (fastpath)                                       8  954629132
         69 db block gets direct                                                      8   95128520
         70 consistent gets                                                           8 4162191256
         71 consistent gets from cache                                                8 2839918855
         72 consistent gets from cache (fastpath)                                     8 2173751438
         73 consistent gets - examination                                             8 1701530557
         74 consistent gets direct                                                    8  420374750
         75 physical reads                                                            8 2263124246
         76 physical reads cache                                                      8 4171507801
         77 physical read flash cache hits                                            8 1672054092
         78 physical reads direct                                                     8 2589616721
         79 physical read IO requests                                                 8  789768877
         80 physical read bytes                                                       8  523531786
         81 db block changes                                                          8  916801489
         82 consistent changes                                                        8 3876379665
         83 recovery blocks read                                                      8 3327333035
         84 recovery blocks read for lost write detection                             8 2677324291
         85 recovery blocks skipped lost write checks                                 8  680578166
         86 physical writes                                                           8 1190468109
         87 physical writes direct                                                    8 2699895516
         88 physical writes from cache                                                8  163083034
         89 physical write IO requests                                                8 2904164198
         90 flash cache inserts                                                       8 2941771786
         91 physical reads direct temporary tablespace                                8 2663793346
         92 physical writes direct temporary tablespace                               8  996415569
         93 physical write bytes                                                      8 3131337131
         94 flash cache eviction: invalidated                                         8 3647825193
         95 flash cache eviction: buffer pinned                                       8 3134415242
         96 flash cache eviction: aged out                                            8 3307935113
         97 flash cache insert skip: not current                                      8 1693383402
         98 flash cache insert skip: DBWR overloaded                                  8 3504558414
         99 flash cache insert skip: exists                                           8 3291155557
        100 flash cache insert skip: not useful                                       8 3620030478
        101 flash cache insert skip: modification                                     8 4128442906
        102 flash cache insert skip: corrupt                                          8 2560222967
        103 db corrupt blocks detected                                                8 1064154723
        104 db corrupt blocks recovered                                               8 3806790612
        105 physical writes non checkpoint                                            8 2602029796
        106 summed dirty queue length                                                 8 1683565474
        107 DBWR checkpoint buffers written                                           8 1208600358
        108 DBWR thread checkpoint buffers written                                    8 3905787588
        109 DBWR tablespace checkpoint buffers written                                8 2649259263
        110 DBWR parallel query checkpoint buffers written                            8 1768645316
        111 DBWR object drop buffers written                                          8  658143835
        112 DBWR transaction table writes                                             8 2146120386
        113 DBWR undo block writes                                                    8  111270822
        114 DBWR revisited being-written buffer                                       8 2773697723
        115 DBWR lru scans                                                            8 2139101792
        116 DBWR checkpoints                                                          8 1732023165
        117 DBWR fusion writes                                                       40 2313150541
        118 prefetch clients - keep                                                   8  574469659
        119 prefetch clients - recycle                                                8 4053781837
        120 prefetch clients - default                                                8 1612053064
        121 prefetch clients - 2k                                                     8  396625644
        122 prefetch clients - 4k                                                     8 3252900252
        123 prefetch clients - 8k                                                     8 1402775714
        124 prefetch clients - 16k                                                    8  792304463
        125 prefetch clients - 32k                                                    8 2351177679
        126 change write time                                                         8 2838938797
        127 exchange deadlocks                                                        8   14632483
        128 free buffer requested                                                     8 3411924934
        129 dirty buffers inspected                                                   8 1344569897
        130 pinned buffers inspected                                                  8  833456521
        131 hot buffers moved to head of LRU                                          8 2030212224
        132 free buffer inspected                                                     8  941676439
        133 commit cleanout failures: write disabled                                  8 2063165199
        134 commit cleanout failures: block lost                                      8  781179189
        135 commit cleanout failures: cannot pin                                      8  176423721
        136 commit cleanout failures: hot backup in progress                          8 2500023621
        137 commit cleanout failures: buffer being written                            8 1626141486
        138 commit cleanout failures: callback failure                                8 3086716748
        139 commit cleanouts                                                          8 2934869719
        140 commit cleanouts successfully completed                                   8 3554314084
        141 recovery array reads                                                      8 2617845348
        142 recovery array read time                                                  8 2996696667
        143 CR blocks created                                                         8  516801181
        144 current blocks converted for CR                                           8 3142330676
        145 switch current to new buffer                                              8 1312802324
        146 write clones created in foreground                                        8 4237693830
        147 write clones created in background                                        8 2988965544
        148 write clones created for recovery                                         8 4053425429
        149 checkpoint clones created for ADG recovery                                8  128034341
        150 recovery block gets from cache                                            8 3434735488
        151 physical reads cache prefetch                                             8  297908839
        152 physical reads prefetch warmup                                            8 3102888545
        153 prefetched blocks aged out before use                                     8 1457461390
        154 prefetch warmup blocks aged out before use                                8 3250306695
        155 prefetch warmup blocks flushed out before use                             8 2218846789
        156 physical reads retry corrupt                                              8  531193461
        157 physical reads direct (lob)                                               8 2564935310
        158 physical writes direct (lob)                                              8 3308932835
        159 cold recycle reads                                                        8  657271764
        160 shared hash latch upgrades - no wait                                      8 2488550671
        161 shared hash latch upgrades - wait                                         8 3380476499
        162 physical reads for flashback new                                          8  473165409
        163 flashback cache read optimizations for block new                          8  756677055
        164 flashback direct read optimizations for block new                         8 1277968430
        165 blocks encrypted                                                          8  584993340
        166 blocks decrypted                                                          8  559990478
        167 calls to kcmgcs                                                         128 2775936802
        168 calls to kcmgrs                                                         128 4210206824
        169 calls to kcmgas                                                         128 4072914524
        170 calls to get snapshot scn: kcmgss                                        32 3128650623
        171 redo blocks read for recovery                                             2 2679943069
        172 redo k-bytes read for recovery                                            2  359782962
        173 redo k-bytes read for terminal recovery                                   2 2068376826
        174 redo entries                                                              2 3488821837
        175 redo size                                                                 2 1236385760
        176 redo entries for lost write detection                                     2 2194106845
        177 redo size for lost write detection                                        2 3835726666
        178 redo size for direct writes                                               2  726277760
        179 redo buffer allocation retries                                            2 1446958922
        180 redo wastage                                                              2 3462806146
        181 redo writes                                                               2 1948353376
        182 redo blocks written                                                       2 2391431605
        183 redo write time                                                           2 3094453259
        184 redo blocks checksummed by FG (exclusive)                                 2  352875884
        185 redo blocks checksummed by LGWR                                           2 1917648704
        186 redo log space requests                                                   2 1985754937
        187 redo log space wait time                                                  2  252430928
        188 redo ordering marks                                                       2 2104561012
        189 redo subscn max counts                                                    2  449106517
        190 redo write broadcast ack time                                             2 1201950653
        191 redo write broadcast ack count                                            2 2144781638
        192 redo write broadcast lgwr post count                                      2 4012338899
        193 redo synch time                                                           2 4215815172
        194 redo synch time (usec)                                                  128  957243500
        195 redo synch writes                                                         2 1439995281
        196 redo synch long waits                                                   128 2758571193
        197 redo synch poll writes                                                    2 3841621897
        198 redo synch polls                                                          2 3455043432
        199 redo KB read                                                              2  872961605
        200 redo KB read (memory)                                                     2 2883054278
        201 redo KB read for transport                                                2 3093608311
        202 redo KB read (memory) for transport                                       2 3933783006
        203 file io service time                                                      1 3999659096
        204 file io wait time                                                         1 1292757183
        205 gc cr blocks served                                                      40 1075941831
        206 gc cr block flush time                                                   40  552470873
        207 gc read wait time                                                        40 3266024004
        208 gc read waits                                                            40   60245462
        209 gc read wait failures                                                    40  141128223
        210 gc read wait timeouts                                                    40 1278481093
        211 gc current blocks served                                                 40   42062110
        212 gc current block pin time                                                40  324533635
        213 gc current block flush time                                              40 4091964965
        214 gc cr blocks received                                                    40 2877738702
        215 gc cr block receive time                                                 40 1759426133
        216 gc current blocks received                                               40  326482564
        217 gc current block receive time                                            40 1388758753
        218 gc local grants                                                          40 3656029643
        219 gc remote grants                                                         40 1406613639
        220 gc kbytes sent                                                           40 3351517689
        221 gc kbytes saved                                                          40 1823613081
        222 gc blocks compressed                                                     40 3506108623
        223 gc blocks lost                                                           40  500461751
        224 gc claim blocks lost                                                     40 1966230523
        225 gc blocks corrupt                                                        40 2288508531
        226 gc CPU used by this session                                              40 4093034494
        227 gc reader bypass grants                                                  40 3930867231
        228 gc cr block build time                                                   40  467525985
        229 gc cr block send time                                                    40 2395315974
        230 gc current block send time                                               40 2750158241
        231 total number of slots                                                     8 2223809671
        232 Effective IO time                                                         8 4166892036
        233 Number of read IOs issued                                                 8 3882100521
        234 background checkpoints started                                            8 3048007007
        235 background checkpoints completed                                          8 2450922463
        236 read-only violation count                                                 1  935461917
        237 number of map operations                                                  8  337177656
        238 number of map misses                                                      8 3618703100
        239 flashback log writes                                                      2 3123176560
        240 flashback log write bytes                                                 2  973553265
        241 cell physical IO bytes saved during optimized file creation              64  372652547
        242 cell physical IO bytes saved during optimized RMAN file restore          64 1445035119
        243 cell physical IO bytes eligible for predicate offload                    64 3064960568
        244 cell physical IO bytes saved by storage index                             8 2245892488
        245 cell smart IO session cache lookups                                      64   22520694
        246 cell smart IO session cache hits                                         64  398350085
        247 cell smart IO session cache soft misses                                  64 2892599795
        248 cell smart IO session cache hard misses                                  64 3263815706
        249 cell smart IO session cache hwm                                          64 3006068088
        250 cell num smart IO sessions in rdbms block IO due to user                 64  753394329
        251 cell num smart IO sessions in rdbms block IO due to no cell mem          64 1205851429
        252 cell num smart IO sessions in rdbms block IO due to big payload          64  256540314
        253 cell num smart IO sessions using passthru mode due to user               64 1852329605
        254 cell num smart IO sessions using passthru mode due to cellsrv            64  636424788
        255 cell num smart IO sessions using passthru mode due to timezone           64 1573034705
        256 cell num smart file creation sessions using rdbms block IO mode          64 2647020488
        257 cell physical IO interconnect bytes returned by smart scan               64 3279818867
        258 cell num fast response sessions                                          64 3241490781
        259 cell num fast response sessions continuing to smart scan                 64 3693748667
        260 cell smart IO allocated memory bytes                                     64 1941917432
        261 cell smart IO memory bytes hwm                                           64 3834681635
        262 cell num active smart IO sessions                                        64 1138018764
        263 cell smart IO sessions hwm                                               64 2011517495
        264 Batched IO vector read count                                             72 3940039938
        265 Batched IO vector block count                                            72  779198283
        266 Batched IO single block count                                            72 3409550379
        267 Batched IO zero block count                                              72 1754742469
        268 Batched IO block miss count                                              72  398227664
        269 Batched IO double miss count                                             72 1818000820
        270 Batched IO (full) vector count                                           72 3326798362
        271 Batched IO (space) vector count                                          72 3732543888
        272 Batched IO (bound) vector count                                          72 2669900039
        273 Batched IO same unit count                                               72 1157040815
        274 Batched IO buffer defrag count                                           72 3691310830
        275 Batched IO slow jump count                                               72  808096169
        276 shared io pool buffer get success                                       128 2964900499
        277 shared io pool buffer get failure                                       128 1112447278
        278 temp space allocated (bytes)                                              1  280471097
        279 serializable aborts                                                       1 1793250745
        280 transaction lock foreground requests                                    128  185785666
        281 transaction lock foreground wait time                                   128 4033661655
        282 transaction lock background gets                                        128 3977359732
        283 transaction lock background get time                                    128 3492664117
        284 undo change vector size                                                 128 1465971540
        285 transaction tables consistent reads - undo records applied              128 1054055970
        286 transaction tables consistent read rollbacks                            128 1396293204
        287 data blocks consistent reads - undo records applied                     128 2915445793
        288 no work - consistent read gets                                          128 2814375799
        289 cleanouts only - consistent read gets                                   128 2904875805
        290 rollbacks only - consistent read gets                                   128 3133064500
        291 cleanouts and rollbacks - consistent read gets                          128 1083903169
        292 RowCR attempts                                                          128 2297882326
        293 RowCR hits                                                              128 3455911385
        294 RowCR - row contention                                                  128 1175104080
        295 RowCR - resume                                                          128 2583359573
        296 rollback changes - undo records applied                                 128 3616249137
        297 transaction rollbacks                                                   128 3988650402
        298 immediate (CURRENT) block cleanout applications                         128 2668233561
        299 immediate (CR) block cleanout applications                              128 3318186802
        300 deferred (CURRENT) block cleanout applications                          128 3388736327
        301 commit txn count during cleanout                                        128 1405359431
        302 active txn count during cleanout                                        128 3378035478
        303 cleanout - number of ktugct calls                                       128 2577316246
        304 immediate CR cleanouts (index blocks)                                   128   79013953
        305 deferred CUR cleanouts (index blocks)                                   128 3827443394
        306 Commit SCN cached                                                       128 2460709063
        307 Cached Commit SCN referenced                                            128 2374582560
        308 Block Cleanout Optim referenced                                         128  750832557
        309 min active SCN optimization applied on CR                               128 2847404927
        310 auto extends on undo tablespace                                         128 3140365462
        311 drop segment calls in space pressure                                    128 1500291109
        312 total number of undo segments dropped                                   128 3623640507
        313 doubling up with imu segment                                            128  723921798
        314 tune down retentions in space pressure                                  128  142917891
        315 steps of tune down ret. in space pressure                               128 3986010614
        316 space was found by tune down                                            128  342698422
        317 space was not found by tune down                                        128  849561940
        318 commit batch/immediate requested                                          1  640321576
        319 commit batch requested                                                    1 2338940602
        320 commit immediate requested                                                1  796663742
        321 commit batch/immediate performed                                          1 3711642721
        322 commit batch performed                                                    1 1391516579
        323 commit immediate performed                                                1 3494177237
        324 commit wait/nowait requested                                              1 3800399491
        325 commit nowait requested                                                   1 3697788123
        326 commit wait requested                                                     1 2843300285
        327 commit wait/nowait performed                                              1 1541239326
        328 commit nowait performed                                                   1  485928497
        329 commit wait performed                                                     1    8047752
        330 global undo segment hints helped                                        128 1791494885
        331 global undo segment hints were stale                                    128 3309048233
        332 local undo segment hints helped                                         128 1047863356
        333 local undo segment hints were stale                                     128 2070200837
        334 undo segment header was pinned                                          128  248401831
        335 IMU commits                                                             128 1914489094
        336 IMU Flushes                                                             128 2099506212
        337 IMU contention                                                          128 2909373607
        338 IMU recursive-transaction flush                                         128 2591100633
        339 IMU undo retention flush                                                128 2087226422
        340 IMU ktichg flush                                                        128 1206609541
        341 IMU bind flushes                                                        128 2756376339
        342 IMU mbu flush                                                           128 3723686946
        343 IMU pool not allocated                                                  128  659017805
        344 IMU CR rollbacks                                                        128 2225124543
        345 IMU undo allocation size                                                128  244193920
        346 IMU Redo allocation size                                                128 3945654623
        347 IMU- failed to get a private strand                                     128 2412863545
        348 Misses for writing mapping                                              128 2725329757
        349 segment dispenser load tasks                                            128 2847264083
        350 segment dispenser load empty                                            128 1005466722
        351 segment dispenser allocations                                           128 2993245266
        352 segment cfs allocations                                                 128 4048061961
        353 segment chunks allocation from disepnser                                128 2015432847
        354 segment total chunk allocation                                          128  322556951
        355 TBS Extension: tasks created                                            128 1488217152
        356 TBS Extension: tasks executed                                           128 1936615790
        357 TBS Extension: files extended                                           128   87307875
        358 TBS Extension: bytes extended                                           128   20854933
        359 total number of times SMON posted                                       128  399827284
        360 SMON posted for undo segment recovery                                   128 2117898593
        361 SMON posted for txn recovery for other instances                        128 1263842513
        362 SMON posted for instance recovery                                       128 4003178738
        363 SMON posted for undo segment shrink                                     128  579492169
        364 SMON posted for dropping temp segment                                   128 3600495721
        365 segment prealloc tasks                                                  128 3177356408
        366 segment prealloc ops                                                    128  189611734
        367 segment prealloc bytes                                                  128  183929521
        368 segment prealloc time (ms)                                              128  219198613
        369 segment prealloc ufs2cfs bytes                                          128  409018059
        370 table scans (short tables)                                               64  345141973
        371 table scans (long tables)                                                64 1042655239
        372 table scans (rowid ranges)                                               64 1303412790
        373 table scans (cache partitions)                                           64  133545664
        374 table scans (direct read)                                                64 3355423586
        375 table scan rows gotten                                                   64 1400824662
        376 table scan blocks gotten                                                 64 3741388076
        377 table fetch by rowid                                                     64  681815839
        378 table fetch continued row                                                64 1413702393
        379 cluster key scans                                                        64 3566804345
        380 cluster key scan block gets                                              64 2006808371
        381 rows fetched via callback                                                64 3299365556
        382 cell scans                                                               64 1117153474
        383 cell blocks processed by cache layer                                    128 1264058236
        384 cell blocks processed by txn layer                                      128 3280964634
        385 cell blocks processed by data layer                                     128  250025093
        386 cell blocks processed by index layer                                    128  412699774
        387 cell commit cache queries                                                64 1111035140
        388 cell transactions found in commit cache                                  64  266637754
        389 cell blocks helped by commit cache                                       64 2220928368
        390 cell blocks helped by minscn optimization                                64  721268882
        391 chained rows skipped by cell                                             64 3337164797
        392 chained rows processed by cell                                           64 1170574055
        393 chained rows rejected by cell                                            64  959925020
        394 cell simulated physical IO bytes eligible for predicate offload         192 3792766660
        395 cell simulated physical IO bytes returned by predicate offload          192 2052798177
        396 cell CUs sent uncompressed                                               64 4129223001
        397 cell CUs sent compressed                                                 64 2900571431
        398 cell CUs sent head piece                                                 64 3911874465
        399 cell CUs processed for uncompressed                                      64   94451592
        400 cell CUs processed for compressed                                        64 1206883245
        401 cell IO uncompressed bytes                                               64 1129546621
        402 queue update without cp update                                          128  528828405
        403 index crx upgrade (prefetch)                                             64 1907142657
        404 index crx upgrade (found)                                                64 1444049043
        405 index crx upgrade (positioned)                                           64 2632952759
        406 leaf node splits                                                        128 1417124053
        407 leaf node 90-10 splits                                                  128 1285138251
        408 branch node splits                                                      128  399027615
        409 root node splits                                                        128  708722985
        410 failed probes on index block reclamation                                128 2687444660
        411 recursive aborts on index block reclamation                             128 3075437189
        412 index reclamation/extension switch                                      128  469799102
        413 native hash arithmetic execute                                           64  321852432
        414 native hash arithmetic fail                                              64 1937851790
        415 lob reads                                                                 8 3626914479
        416 lob writes                                                                8 2682192071
        417 lob writes unaligned                                                      8 4224694283
        418 cell index scans                                                         64 3427136437
        419 index fast full scans (full)                                             64   12081473
        420 index fast full scans (rowid ranges)                                     64 1555464060
        421 index fast full scans (direct read)                                      64 1635662180
        422 index fetch by key                                                      128 2808364230
        423 index scans kdiixs1                                                     128 3589793292
        424 queue splits                                                            128 1168925905
        425 queue flush                                                             128 3150060076
        426 queue position update                                                   128 2568542507
        427 queue single row                                                        128 2713404457
        428 queue ocp pages                                                         128 3899522644
        429 queue qno pages                                                         128 2998782417
        430 heap block compress                                                      64 2326757257
        431 HSC OLTP Space Saving                                                    64  841396643
        432 HSC OLTP Compressed Blocks                                               64 2175876847
        433 HSC IDL Compressed Blocks                                                64 2406770549
        434 HSC Compressed Segment Block Changes                                     64  539480718
        435 HSC Heap Segment Block Changes                                           64  399567576
        436 HSC OLTP Non Compressible Blocks                                         64  262999502
        437 HSC OLTP positive compression                                           128 1017140011
        438 HSC OLTP negative compression                                           128  269936937
        439 HSC OLTP recursive compression                                          128   57927558
        440 HSC OLTP inline compression                                             128 2650019963
        441 HSC OLTP Drop Column                                                    128  559591604
        442 HSC OLTP Compression skipped rows                                       128 3456750894
        443 HSC OLTP compression block checked                                      128 2637393546
        444 Heap Segment Array Inserts                                               64 1532155417
        445 Heap Segment Array Updates                                               64 2275749997
        446 securefile allocation bytes                                             128 3597129675
        447 securefile allocation chunks                                            128 2011127012
        448 securefile direct read bytes                                            128  716648152
        449 securefile direct write bytes                                           128 3429235578
        450 securefile direct read ops                                              128 3240523075
        451 securefile direct write ops                                             128 1150219561
        452 securefile inode read time                                              128 4019396886
        453 securefile inode write time                                             128 2268799257
        454 securefile inode ioreap time                                            128 3735572547
        455 securefile bytes non-transformed                                        128 3951297587
        456 securefile number of non-transformed flushes                            128 4098565707
        457 securefile bytes encrypted                                              128 2777111815
        458 securefile bytes cleartext                                              128 3732194274
        459 securefile compressed bytes                                             128  155601069
        460 securefile uncompressed bytes                                           128 3014741102
        461 securefile bytes deduplicated                                           128 3725763856
        462 securefile create dedup set                                             128  315944074
        463 securefile destroy dedup set                                            128 1033064527
        464 securefile add dedupd lob to set                                        128  417001337
        465 securefile rmv from dedup set                                           128  260212603
        466 securefile reject deduplication                                         128 2469868456
        467 securefile dedup prefix hash match                                      128   45267420
        468 securefile number of flushes                                            128  695283106
        469 securefile dedup flush too low                                          128 2538132497
        470 securefile dedup callback oper final                                    128 3751127546
        471 securefile dedup hash collision                                         128  474756722
        472 securefile dedup fits inline                                            128  811020833
        473 EHCC CUs Compressed                                                     128  367847514
        474 EHCC Query Low CUs Compressed                                           128 3245723647
        475 EHCC Query High CUs Compressed                                          128 3382680758
        476 EHCC Archive CUs Compressed                                             128 2332476297
        477 EHCC Compressed Length Compressed                                       128 4194752021
        478 EHCC Decompressed Length Compressed                                     128 2639391085
        479 EHCC Rows Compressed                                                    128  781935931
        480 EHCC Rows Not Compressed                                                128 3525654818
        481 EHCC CU Row Pieces Compressed                                           128 1875994900
        482 EHCC CUs Decompressed                                                   128 2050416976
        483 EHCC Query Low CUs Decompressed                                         128 1294049085
        484 EHCC Query High CUs Decompressed                                        128  658646273
        485 EHCC Archive CUs Decompressed                                           128 3219000004
        486 EHCC Compressed Length Decompressed                                     128 3359669819
        487 EHCC Decompressed Length Decompressed                                   128 1376060606
        488 EHCC Columns Decompressed                                               128 3449104294
        489 EHCC Total Columns for Decompression                                    128 3772480754
        490 EHCC Total Rows for Decompression                                       128  626128372
        491 EHCC Pieces Buffered for Decompression                                  128 1843043005
        492 EHCC Total Pieces for Decompression                                     128 1269622577
        493 EHCC DML CUs Decompressed                                               128 2171628482
        494 EHCC Normal Scan CUs Decompressed                                       128   12676786
        495 EHCC Turbo Scan CUs Decompressed                                        128 2177750092
        496 EHCC Rowid CUs Decompressed                                             128 1639970104
        497 EHCC Analyze CUs Decompressed                                           128 1754934147
        498 EHCC Dump CUs Decompressed                                              128  490679437
        499 EHCC Check CUs Decompressed                                             128 3824258835
        500 EHCC Analyzer Calls                                                     128 2609447759
        501 sql area purged                                                          64 2763387941
        502 sql area evicted                                                         64 3224599022
        503 CCursor + sql area evicted                                               64  938276153
        504 No. of Encrypt ops                                                        1 3364959674
        505 No. of Decrypt ops                                                        1 1118476298
        506 No. of XS Sessions Created                                                1   84820840
        507 No. of XS Sessions Attached                                               1 1249145894
        508 No. of Namespaces Created                                                 1 1052652127
        509 No. of User Callbacks Executed                                            1 2910344476
        510 No. of Roles Enabled or Disabled                                          1 1422657893
        511 No. of Principal Cache Misses                                             1 1497811853
        512 No. of Principal Invalidations                                            1 1130152043
        513 DX/BB enqueue lock foreground requests                                  128  560233336
        514 DX/BB enqueue lock foreground wait time                                 128 1889009391
        515 DX/BB enqueue lock background gets                                      128 2384348591
        516 DX/BB enqueue lock background get time                                  128 1423799991
        517 Clusterwide global transactions                                          33 4124661496
        518 Clusterwide global transactions spanning RAC nodes                       33 3534283427
        519 Forwarded 2PC commands across RAC nodes                                  33 4274163731
        520 GTX processes spawned by autotune                                        32  719092076
        521 GTX processes stopped by autotune                                        32  457066669
        522 session cursor cache hits                                                64 3678609077
        523 session cursor cache count                                               64  568260813
        524 java call heap total size                                                 1 1649812842
        525 java call heap total size max                                             1  580075922
        526 java call heap used size                                                  1  187277223
        527 java call heap used size max                                              1  625960724
        528 java call heap live size                                                  1 2431389341
        529 java call heap live size max                                              1 1298432410
        530 java call heap object count                                               1 3472185722
        531 java call heap object count max                                           1 1862536587
        532 java call heap live object count                                          1  632577394
        533 java call heap live object count max                                      1 2964139762
        534 java call heap gc count                                                   1 2284697213
        535 java call heap collected count                                            1 2510746206
        536 java call heap collected bytes                                            1 3585877838
        537 java session heap used size                                               1 1661140639
        538 java session heap used size max                                           1 1726629032
        539 java session heap live size                                               1 2257986540
        540 java session heap live size max                                           1 1960804148
        541 java session heap object count                                            1 4072938679
        542 java session heap object count max                                        1  469647992
        543 java session heap live object count                                       1  225051972
        544 java session heap live object count max                                   1 3755633366
        545 java session heap gc count                                                1 3363147808
        546 java session heap collected count                                         1 3795934475
        547 java session heap collected bytes                                         1 3976434298
        548 cursor authentications                                                  128 4069981174
        549 queries parallelized                                                     32 3315614405
        550 DML statements parallelized                                              32 3791923855
        551 DDL statements parallelized                                              32 4115134636
        552 DFO trees parallelized                                                   32 2753131890
        553 Parallel operations not downgraded                                       32 2410168744
        554 Parallel operations downgraded to serial                                 32 4286011915
        555 Parallel operations downgraded 75 to 99 pct                              32  322858058
        556 Parallel operations downgraded 50 to 75 pct                              32 3281923117
        557 Parallel operations downgraded 25 to 50 pct                              32 3330456527
        558 Parallel operations downgraded 1 to 25 pct                               32 3721245209
        559 PX local messages sent                                                   32  506655048
        560 PX local messages recv'd                                                 32 1437798390
        561 PX remote messages sent                                                  32 2567415317
        562 PX remote messages recv'd                                                32 2537140420
        563 buffer is pinned count                                                   72 1300470380
        564 buffer is not pinned count                                               72 2670431739
        565 no buffer to keep pinned count                                           72 3528454686
        566 workarea memory allocated                                                64 2433935387
        567 workarea executions - optimal                                            64 3211650785
        568 workarea executions - onepass                                            64  798730793
        569 workarea executions - multipass                                          64 3804491469
        570 LOB table id lookup cache misses                                        128 1983401898
        571 parse time cpu                                                           64  206905303
        572 parse time elapsed                                                       64 1431595225
        573 parse count (total)                                                      64   63887964
        574 parse count (hard)                                                       64  143509059
        575 parse count (failures)                                                   64 1118776443
        576 parse count (describe)                                                   64  469016317
        577 frame signature mismatch                                                 64  959148951
        578 execute count                                                            64 2453370665
        579 bytes sent via SQL*Net to client                                          1 2967415760
        580 bytes received via SQL*Net from client                                    1  161936656
        581 SQL*Net roundtrips to/from client                                         1  159846526
        582 bytes sent via SQL*Net to dblink                                          1 1622773540
        583 bytes received via SQL*Net from dblink                                    1 1983609624
        584 SQL*Net roundtrips to/from dblink                                         1 2420448902
        585 bytes via SQL*Net vector to client                                        1  763712542
        586 bytes via SQL*Net vector from client                                      1 2635744375
        587 bytes via SQL*Net vector to dblink                                        1  242642371
        588 bytes via SQL*Net vector from dblink                                      1 3412995477
        589 sorts (memory)                                                           64 2091983730
        590 sorts (disk)                                                             64 2533123502
        591 sorts (rows)                                                             64 3757672740
        592 OTC commit optimization attempts                                        128 2480822770
        593 OTC commit optimization hits                                            128 4064864054
        594 OTC commit optimization failure - setup                                 128 3633344886
        595 cell flash cache read hits                                                8 2923827453
        596 Workload Capture: size (in bytes) of recording                            1 2146126248
        597 Workload Capture: dbtime                                                  1 3533966785
        598 Workload Capture: user calls                                              1 1228651202
        599 Workload Capture: user calls flushed                                      1 2236307043
        600 Workload Capture: unreplayable user calls                                 1 3283547595
        601 Workload Capture: user txns                                               1 3034767909
        602 Workload Capture: user logins                                             1 1296083012
        603 Workload Capture: unsupported user calls                                  1 2224534227
        604 Workload Capture: errors                                                  1 1278172735
        605 Workload Replay: dbtime                                                   1  443726121
        606 Workload Replay: network time                                             1 2824611432
        607 Workload Replay: think time                                               1 4246044927
        608 Workload Replay: time gain                                                1  849876091
        609 Workload Replay: time loss                                                1 2223483653
        610 Workload Replay: user calls                                               1  626148611
        611 Workload Replay: deadlocks resolved                                       1 2446501167

 612 rows selected.