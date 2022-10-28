# CorrectFiles
FEC Archiver - Reed-Solomon coding for archive files (not yet implemented)

## Basic Idea
Encode large container files (e.g. .tgz, .tar.gz, zip, webm, mp4) in a fec-archive such that, if 
these archives contain errors induced by a storage medium, these archives can be fully recovered 
and restored, as long as the information theoretic boundaries are not violated.

Reasons for such partial dataloss are plenty, think of bitrot on a disk, erasures of a flash cell, or 
scratches on an optical medium, in every case we may want to be able to add enough redundancy to that
archive, such that we are fully able to recover from a defined scenario of loss of data.

The idea is to be able to restore corrupted or lost data, from remaining files/data, which we were able 
to recover from the medium and with enough redundancy and cleverly used block codes, we might be able to
recover all data using an 2D/3D iterative solver, which can hopefully even solve large portions and burst
losses and erasures.

I am fully aware that some commercially available archiver tools can perfectly do this job, but this
is more about the journey and the documented encoding and decoding process, such that it can be handled
like any other container format and can be streamed / played / restored directly. The idea is more like 
having a split transport stream, which contains raw data and interleaved blocks containing FEC-Data.

## Not yet implemented
This is just the project start and contains no code yet. Idea is to implement RS-Coding probably with
Python, then Java, then Rust or so.

I do not plan an archived file for multiple files, this is where tar and other container formats come
into use. That may change, but at the moment I want to archive like 20 GB of data such that a redundancy
of 20% can be added and still fits on a BluRay and has a maximum possible recovery rate of up to 20%
erasures.

After being able to recover these data, i want to make encoding as fast as possible, and the solver
to solve as robust as possible, maybe in an iterative sodoku style, when a very complicated erasure 
pattern is found, which is solvable, if you solve it in the correct order.

## Algorithms
We may or may not find some cool (unusual) and/or fast algorithms along the way. My hope is maybe we can
find a high performance Reed-Solomon-Encoder and or Decoder along this journey.

I had some background in signal ransmission theory and channel coding, but most of my knowledge vanished
so I also want to recover my lost knowledge about this. This project is the perfect challenge and reason
to recover some of my former knowledge.
